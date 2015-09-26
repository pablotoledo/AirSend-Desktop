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
import java.util.ArrayList;

/**
 * Clase de abstracción para la el sondeo que aisla la lógica interna a las
 * capas superiores
 *
 * @author Pablo
 */
public class NucleoSondeo {

    public static int puertoBroadcast = 8585;
    public static String dirBroadcast = "255.255.255.255";
    public static int tiempoSleppLoopSondeo = 3000;

    private Thread hiloEmisorSondeo;
    private Thread hiloReceptorSondeo;
    private EmisorSondeo emisorSondeo;
    private ReceptorSondeo receptoSondeo;

    /**
     * Constructor
     */
    public NucleoSondeo() {
        this.emisorSondeo = new EmisorSondeo();
        this.receptoSondeo = new ReceptorSondeo();
        this.hiloEmisorSondeo = new Thread(this.emisorSondeo);
        this.hiloReceptorSondeo = new Thread(this.receptoSondeo);
        this.hiloEmisorSondeo.start();
        this.hiloReceptorSondeo.start();
    }

    /**
     * Permite objetener una lista de elementos recibidos y actualizada
     * @return Lista de elementos recibidos y actualizada
     */
    public ArrayList<MensajeSondeoJSON> getListaElementos() {
        return this.receptoSondeo.getLista();
    }

}
