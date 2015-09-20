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
package airsendtfg.recursos;

/**
 *
 * @author Pablo
 */
public class Persistencia {
    private static boolean licencia;
    private static String nombreUsuario;
    private static String gatoUsuario;

    public static void setLicencia(boolean licencia) {
        Persistencia.licencia = licencia;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        Persistencia.nombreUsuario = nombreUsuario;
    }

    public static void setGatoUsuario(String gatoUsuario) {
        Persistencia.gatoUsuario = gatoUsuario;
    }

    public static boolean isLicencia() {
        return licencia;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static String getGatoUsuario() {
        return gatoUsuario;
    }
    
    
}
