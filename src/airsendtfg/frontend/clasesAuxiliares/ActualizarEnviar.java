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

import airsendtfg.frontend.EnviarVentana;
import airsendtfg.librearias.nucleo.negociacion.MensajeNegociacionJSON;
import airsendtfg.librearias.nucleo.negociacion.NucleoNegociacion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class ActualizarEnviar implements Runnable {
    
    private EnviarVentana ventana;
    private MensajeNegociacionJSON mensaje;
    
    public ActualizarEnviar(EnviarVentana clase, MensajeNegociacionJSON mensaje){
        this.ventana = clase;
        this.mensaje = mensaje;
    }
    
    private void actualizarEstado(){
        MensajeNegociacionJSON mensaje;
        String estado;
        while(true){
            try {
                mensaje = NucleoNegociacion.recuperarMensaje(this.mensaje.getIdentificadorMensaje());
                estado = mensaje.getTipoMensaje();
                if(estado.equals(mensaje.equals(NucleoNegociacion.tipoMensajes[0]))){
                    this.ventana.setTextoEstado("Estado: Propuesta enviada");
                }
                if(estado.equals(mensaje.equals(NucleoNegociacion.tipoMensajes[1]))){
                    this.ventana.setTextoEstado("Estado: Propuesta aceptada");
                }
                if(estado.equals(mensaje.equals(NucleoNegociacion.tipoMensajes[2]))){
                    this.ventana.setTextoEstado("Estado: Propuesta denegada");
                    break;
                }
                if(estado.equals(mensaje.equals(NucleoNegociacion.tipoMensajes[3]))){
                    this.ventana.setTextoEstado("Estado: Transferencia en progreso");
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ActualizarEnviar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() {
        this.actualizarEstado();
    }
    
}
