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
package airsendtfg.frontend.nucleo;

import airsendtfg.librerias.nucleo.sondeo.NucleoSondeo;

/**
 *
 * @author Pablo
 */
public class NucleoAirSend {
    
    private static NucleoSondeo nucleoSondeo;
    //nucleoTransferencia
    //nucleoNegociacion
    
    public static void cargarNucleos(){
        nucleoSondeo = new NucleoSondeo();
    }
    
    
}
