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

import airsendtfg.recursos.Persistencia;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class MensajeSondeoJSON {

    private String sistemaOperativo;
    private String nombreEquipo;
    private String nombreUsuario;
    private String direccionIP;
    private String tiempo;
    private String iconoUsuario;

    /**
     * Constructor de clase
     */
    public MensajeSondeoJSON() {
        try {
            this.sistemaOperativo = System.getProperty("os.name");;
            this.nombreEquipo = InetAddress.getLocalHost().getHostName();
            this.nombreUsuario = Persistencia.getNombreUsuario();
            this.direccionIP = "";
            this.iconoUsuario = Persistencia.getGatoUsuario();
            this.tiempo = new Timestamp(System.currentTimeMillis()).toString();
        } catch (UnknownHostException ex) {
            Logger.getLogger(MensajeSondeoJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Getters para la clase GSON
    public String getIconoUsuario() {
        return iconoUsuario;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    //Comparador de clase bajo criterios específicos
    public boolean igual(MensajeSondeoJSON entrada) {
        return entrada.sistemaOperativo.equals(this.sistemaOperativo) && entrada.getNombreEquipo().equals(this.nombreEquipo) && entrada.getNombreUsuario().equals(this.nombreUsuario);
    }

}
