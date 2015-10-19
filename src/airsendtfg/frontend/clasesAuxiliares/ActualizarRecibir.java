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
package airsendtfg.frontend.clasesAuxiliares;

import airsendtfg.frontend.RecibirVentana;
import airsendtfg.librerias.nucleo.negociacion.MensajeNegociacionJSON;
import airsendtfg.librerias.nucleo.negociacion.NucleoNegociacion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class ActualizarRecibir implements Runnable{
    private RecibirVentana ventana;
    private MensajeNegociacionJSON mensaje;
    
    public ActualizarRecibir(RecibirVentana clase, MensajeNegociacionJSON mensaje){
        this.ventana = clase;
        this.mensaje = mensaje;
    }
    
    private void actualizarEstado(){
        MensajeNegociacionJSON mensaje;
        
        while(true){
            try {
                Thread.sleep(3000);
                mensaje = NucleoNegociacion.recuperarMensaje(this.mensaje.getIdentificadorMensaje());
                String estado = mensaje.getTipoMensaje();
                if(estado.equals(MensajeNegociacionJSON.tipoMensajes[0])){
                    this.ventana.setTextoEstado("Estado: Propuesta enviada");
                }
                if(estado.equals(MensajeNegociacionJSON.tipoMensajes[1])){
                    this.ventana.setTextoEstado("Estado: Propuesta aceptada");
                }
                if(estado.equals(MensajeNegociacionJSON.tipoMensajes[2])){
                    this.ventana.setTextoEstado("Estado: Propuesta denegada");
                    this.ventana.setTextoBtnCancelar("Salir");
                    break;
                }
                if(estado.equals(MensajeNegociacionJSON.tipoMensajes[3])){
                    this.ventana.setTextoEstado("Estado: Transferencia en progreso");
                    this.ventana.setValorBarra(this.ventana.getReceptor().getProgreso());
                }
                if(estado.equals(MensajeNegociacionJSON.tipoMensajes[4])){
                    this.ventana.setTextoEstado("Estado: Transferencia completada");
                    this.ventana.setTextoBtnCancelar("Salir");
                    this.ventana.getBarra().setMaximum(1);
                    this.ventana.getBarra().setValue(1);
                    break;
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex1) {
                    Logger.getLogger(ActualizarRecibir.class.getName()).log(Level.SEVERE, null, ex1);
                }
                actualizarEstado();
            }
        }
    }
    
    

    @Override
    public void run() {
        this.actualizarEstado();
    }
    
}
