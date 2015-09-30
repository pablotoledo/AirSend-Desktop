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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pablo
 */
public class NucleoNegociacion {
    //Lista que define los tipos de mensajes posibles
    public static final String[] tipoMensajes = {"PROPUESTA", "ACEPTADO", "DENEGADO", "COMIENZO"};
    
    protected static Map<String, MensajeNegociacionJSON> listaPropuesta = new HashMap<String, MensajeNegociacionJSON>();
    protected static Map<String, MensajeNegociacionJSON> listaAceptado = new HashMap<String, MensajeNegociacionJSON>();
    protected static Map<String, MensajeNegociacionJSON> listaDenegado = new HashMap<String, MensajeNegociacionJSON>();
    protected static Map<String, MensajeNegociacionJSON> listaComienzo = new HashMap<String, MensajeNegociacionJSON>();
    
    //Puertos
    public static int puertoNucleoNegociacion = 8586;
    
    private Thread hiloReceptor;
    
    
    public NucleoNegociacion(){
        this.hiloReceptor = new Thread(new ReceptorNegociacion());
        this.hiloReceptor.start();
    }
}