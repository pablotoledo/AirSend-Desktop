/*
 * Copyright 2014 juanpablotoledogavagnin.
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
package airsendtfg.utilidades;

import java.io.File;
import java.text.DecimalFormat;

/**
 *
 * @author juanpablotoledogavagnin
 */
public class Utilidades {

    /**
     * Permite el calculo del peso de un array de File y devuelve la fecha en
     * formato String #.## MB
     *
     * @param lista
     * @return String formato #.## MB
     */
    public static String calcularTamano(File[] lista) {
        double peso = 0;
        for (int i = 0; i < lista.length; i++) {
            peso = peso + extraccionRecursiva(lista[i]);
        }
        peso = peso / (1024 * 1024);
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(peso);
    }

    /**
     * Permite el calculo del peso de un array de File y devuelve la fecha en
     * formato double
     *
     * @param lista
     * @return String formato #.## MB
     */
    public static double calcularTamanoD(File[] lista) {
        double peso = 0;
        for (int i = 0; i < lista.length; i++) {
            peso = peso + extraccionRecursiva(lista[i]);
        }
        peso = peso / (1024 * 1024);
        return peso;
    }

    /**
     * Método auxiliar para el cálculo recursivo de los File que son directorios
     *
     * @param entrada
     * @return
     */
    private static long extraccionRecursiva(File entrada) {
        long length = 0;
        if (entrada.isDirectory()) {
            for (File file : entrada.listFiles()) {
                if (file.isFile()) {
                    length += file.length();
                } else {
                    length += extraccionRecursiva(file);
                }
            }
        } else {
            length = entrada.length();
        }

        return length;
    }

}
