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
package airsendtfg.frontend.nucleo.negociacion;

import airsendtfg.librerias.utilidades.Utilidades;
import airsendtfg.recursos.Persistencia;
import java.io.File;

/**
 *
 * @author Pablo
 */
public class MensajeNegociacionJSON {
    
    private String identificadorMensaje; //Identificador único del mensaje actual
    private String identificadorEmisor; //Identificador del sistema que enviará los archivos
    private String identificadorDestinatario; //Identificador del sistema que enviará los archivos
    private File[] listaElementos; //Lista de archivos que van a ser enviados
    private double tamano; // Tamaño total en MB del conjunto File[] a enviar
    private String nombreEmisor; // Nombre del dispositivo emisor
    private String ipEmisor; // IP del sistema emisor
    private String ipDestinatario; //IP del sistema destino
    private String tipoMensaje; // Tipología del actual objeto mensaje
    private int puertoReceptorTransferencia; // Puerto asignado para comenzar a recibir datos
    
    //Lista que define los tipos de mensajes posibles
    public static final String[] tipoMensajes = {"PROPUESTA", "ACEPTADO", "DENEGADO", "COMIENZO"};
    
    public MensajeNegociacionJSON(File[] listaArchivos, String ipDestino, String idDestinatario){
        this.listaElementos = listaArchivos;
        this.identificadorEmisor = Persistencia.getIdUsuario();
        this.tamano = Utilidades.calcularTamanoD(listaArchivos);
        this.nombreEmisor = Persistencia.getNombreUsuario();
        this.tipoMensaje = this.tipoMensajes[0];
        this.ipDestinatario = ipDestino;
        this.identificadorDestinatario = idDestinatario;
    }

    //Setters
    public void setListaElementos(File[] listaElementos) {
        this.listaElementos = listaElementos;
    }

    public void setIpEmisor(String ipEmisor) {
        this.ipEmisor = ipEmisor;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public void setPuertoReceptorTransferencia(int puertoReceptorTransferencia) {
        this.puertoReceptorTransferencia = puertoReceptorTransferencia;
    }
    
    //Getters
    public String getIdentificadorMensaje() {
        return identificadorMensaje;
    }

    public String getIpDestinatario() {
        return ipDestinatario;
    }

    public String getIdentificadorEmisor() {
        return identificadorEmisor;
    }

    public File[] getListaElementos() {
        return listaElementos;
    }

    public double getTamano() {
        return tamano;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public String getIpEmisor() {
        return ipEmisor;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public int getPuertoReceptorTransferencia() {
        return puertoReceptorTransferencia;
    }

    public static String[] getTipoMensajes() {
        return tipoMensajes;
    }
    
    
    
}
