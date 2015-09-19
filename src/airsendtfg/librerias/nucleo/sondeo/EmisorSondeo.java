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
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class EmisorSondeo implements Runnable {

    private DatagramSocket socket;

    private void emitirSondeo() {
        try {
            while (true) {
                //Preparamos un socket en un puerto aleatorio para enviar el datagrama UDP
                MensajeSondeoJSON mensaje = new MensajeSondeoJSON();
                final Gson gson = new Gson();
                String mensajeJSON =(String) gson.toJson(mensaje);
                socket = new DatagramSocket();
                socket.setBroadcast(true);
                byte[] bufferMensaje = mensajeJSON.getBytes("UTF8");

                //Se propaga inicialmente el datagrama por 255.255.255.255
                try {
                    DatagramPacket sendPacket = new DatagramPacket(bufferMensaje, bufferMensaje.length, InetAddress.getByName(NucleoSondeo.dirBroadcast), NucleoSondeo.puertoBroadcast);
                    socket.send(sendPacket);
                } catch (Exception e) {
                    System.err.printf(e.getLocalizedMessage());
                }

                // Se envía el mensaje manualmente por cada red conectada
                Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
                while (interfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();
                    if (networkInterface.isLoopback() || !networkInterface.isUp()) {
                        continue; // Evitamos un posible bucle
                    }
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        //Para cada dispositivo
                        InetAddress broadcast = interfaceAddress.getBroadcast();
                        if (broadcast == null) {
                            continue;
                        }
                        //Propagamos el mensaje por la red
                        try {
                            DatagramPacket enviarDatagrama = new DatagramPacket(bufferMensaje, bufferMensaje.length, broadcast, NucleoSondeo.puertoBroadcast);
                            socket.send(enviarDatagrama);
                        } catch (Exception e) {
                            System.err.printf(e.getLocalizedMessage());
                        }
                    }
                }
                System.out.println(">>> Sonda enviada en todos los dispositivos de red disponibles "+mensajeJSON);
                socket.close();
                Thread.sleep(NucleoSondeo.tiempoSleppLoopSondeo);
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(EmisorSondeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        this.emitirSondeo();
    }

}
