/*
 * Copyright 2015 Pablo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package airsendtfg.librerias.nucleo.sondeo;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class ReceptorSondeo implements Runnable {

    private DatagramSocket socket;
    private ArrayList<MensajeSondeoJSON> lista = new ArrayList();
    private ArrayList<String> listaIPsActual = new ArrayList();

    /**
     * Este método lista todas las IPs a las que está conectado el sistema y si
     * hay cambios lo refleja en el atributo de la clase
     */
    private void listarIPsLocales() {
        ArrayList nueva = this.listaIPs();
        if (!this.listaIPsActual.equals(nueva)) {
            //Log.sondeoReceptor("Cambio de interfaces de red detectado!");
            this.listaIPsActual = nueva;
        } else {
            // Log.sondeoReceptor("La lista de interfaces de red del sistema actual no ha variado");
        }
    }

    /**
     * Este método devuelve una lista de IPs de las interfaces de red del
     * sistema actual
     *
     * @return
     */
    private ArrayList listaIPs() {
        ArrayList<String> listaActual = new ArrayList();
        try {
            //Log.sondeoReceptor("Se listan las IPs locales y se almacenan para descartar mensajes locales");
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets)) {
                //Log.error("Nombre de interfaz " + netint.getDisplayName());
                Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                    //Log.sondeoReceptor("IPs " + inetAddress.getHostAddress());
                    if (!listaActual.contains(inetAddress.getHostAddress())) {
                        listaActual.add(inetAddress.getHostAddress());
                    }
                }
            }
            //Log.sondeoReceptor("Tamaño de la lista de IPs locales de los interfaces de red del sistema actual" + listaActual.size());
        } catch (SocketException ex) {
            //Log.error(ex.getLocalizedMessage());
        }
        return listaActual;
    }

    /**
     * Este método se encarga de procesar datagramas
     */
    public void recibirSondeo() {
        try {
            //Preparamos un socket para recibir datagramas de sondeo
            this.listarIPsLocales();
            socket = new DatagramSocket(NucleoSondeo.puertoBroadcast, InetAddress.getByName("0.0.0.0"));
            socket.setBroadcast(true);
            while (true) {
                //Nos preparamos para escuchar un datagrama
                byte[] bufferMensaje = new byte[500];
                DatagramPacket packet = new DatagramPacket(bufferMensaje, bufferMensaje.length);
                socket.receive(packet);

                //Adaptamos el mensaje recibido para su conversion a String
                String mensajeIP = new String(packet.getData());
                //Extraemos el JSON del mensaje
                mensajeIP = mensajeIP.substring(0, mensajeIP.lastIndexOf('}') + 1);
                //Convertirmos el JSON en el objeto Java que nos interesa
                MensajeSondeoJSON mensajeJSON = new Gson().fromJson(mensajeIP, MensajeSondeoJSON.class);
                //Asignamos la IP de origen del equipo que envió el mensaje
                mensajeJSON.setDireccionIP(packet.getAddress().getHostAddress());
                //System.err.println(new Gson().toJson(mensajeJSON).toString());
                this.procesarMensajeSondeoJSON(mensajeJSON);
            }
        } catch (IOException | JsonSyntaxException ex) {
            Logger.getLogger(ReceptorSondeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void procesarMensajeSondeoJSON(MensajeSondeoJSON mensaje) throws UnknownHostException {
        /*Con este método se añade un dispositivo a nuestra lista
         si se cumple
         - No está en la lista
         - Su IP no es la local 127.0.0.1
         */
        boolean bandera = true;
        for (MensajeSondeoJSON disp : this.lista) {
            bandera = !disp.igual(mensaje);
        }
        //Solo aquellos mensajes que no sean nuestros pasarán a la lista de dispositivos
        if (bandera) {
            if (!this.listaIPsActual.contains(mensaje.getDireccionIP())) {
                this.lista.add(mensaje);
                System.out.println("!ReceptorSondeo Se crea dispositivo! " + new Gson().toJson(mensaje).toString());
            }
        }
    }

    @Override
    public void run() {
        this.mantenerListasActualizadas();
        this.recibirSondeo();
    }

    /**
     * Este método genera un hilo anónimo para gestionar que la lista de
     * dispositivos se mantenga actualizada
     */
    private void mantenerListasActualizadas() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (true) {
                                //Actualizamos la lista de IPs locales
                                listarIPsLocales();
                                //Vaciamos elementos viejos de la lista de dispositivos
                                SimpleDateFormat formateadorTiempo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                Date tiempo = new Date();
                                for (int i = 0; i < lista.size(); i++) {
                                    Date tiempoElemento = formateadorTiempo.parse(lista.get(i).getTiempo());
                                    long diferenciaTiempo = tiempo.getTime() - tiempoElemento.getTime();
                                    diferenciaTiempo = TimeUnit.MILLISECONDS.toSeconds(diferenciaTiempo);
                                    if (diferenciaTiempo > 60) {
                                        lista.remove(i);
                                        System.err.println("Elemento eliminado de la lista");
                                        break;
                                    }
                                }
                                Thread.sleep(NucleoSondeo.tiempoSleppLoopSondeo * 5);
                            }
                        } catch (ParseException | InterruptedException ex) {
                            Logger.getLogger(ReceptorSondeo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
        ).start();
    }

    public ArrayList<MensajeSondeoJSON> getLista() {
        return lista;
    }

}
