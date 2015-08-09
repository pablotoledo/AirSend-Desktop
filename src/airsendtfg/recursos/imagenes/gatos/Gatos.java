/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsendtfg.recursos.imagenes.gatos;

import airsendtfg.frontend.MenuConfigInicial;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class Gatos {

    private static ArrayList<File> listaGatosGrande = new ArrayList();
    private static ArrayList<File> listaGatosMediano = new ArrayList();
    private static ArrayList<File> listaGatosPeque = new ArrayList();
    private static ArrayList<String> listaIconos = new ArrayList();
    private static boolean cargar = true;

    public static void cargarListas() {
        if (cargar) {
            recorrerCarpeta("/airsendtfg/recursos/imagenes/gatos/64x64/", listaGatosPeque);
            recorrerCarpeta("/airsendtfg/recursos/imagenes/gatos/128x128/", listaGatosMediano);
            recorrerCarpeta("/airsendtfg/recursos/imagenes/gatos/256x256/", listaGatosGrande);
            for (File elemento : listaGatosGrande) {
                listaIconos.add(elemento.getName());
            }
            cargar = false;
        }
    }

    private static void recorrerCarpeta(String carpeta, ArrayList<File> variable) {
        URL url = Gatos.class.getResource(carpeta);
        try {
            File dir = new File(url.toURI());
            for (File archivo : dir.listFiles()) {
                //System.out.println(archivo.getName());
                variable.add(archivo);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(MenuConfigInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static File getGatoGrande(String nombre) {
        return getGato(nombre, listaGatosGrande);
    }

    public static File getGatoMediano(String nombre) {
        return getGato(nombre, listaGatosMediano);
    }

    public static File getGatoPeque(String nombre) {
        return getGato(nombre, listaGatosPeque);
    }

    public static ArrayList<File> getListaGatosGrande() {
        return listaGatosGrande;
    }

    public static ArrayList<File> getListaGatosMediano() {
        return listaGatosMediano;
    }

    public static ArrayList<File> getListaGatosPeque() {
        return listaGatosPeque;
    }

    public static ArrayList<String> getListaIconos() {
        return listaIconos;
    }

    private static File getGato(String nombre, ArrayList<File> tipo) {
        for (File elemento : tipo) {
            if (elemento.getName().equals(nombre)) {
                return elemento;
            }
        }
        return null;
    }
}
