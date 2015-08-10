/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsendtfg.recursos.imagenes.gatos;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Gatos {

    private static ArrayList<String> listaGatosGrande = new ArrayList();
    private static ArrayList<String> listaGatosMediano = new ArrayList();
    private static ArrayList<String> listaGatosPeque = new ArrayList();

    private static boolean cargar = true;
    private static String[] listado = {"cat_banjo.png", "cat_bd.png", "cat_birdhouse.png", "cat_box.png", "cat_cage.png", "cat_cart.png",
        "cat_clean.png", "cat_cupid.png", "cat_drink.png", "cat_drunk.png", "cat_eyes.png",
        "cat_fat.png", "cat_fight.png", "cat_fish.png", "cat_food.png", "cat_fridge.png", "cat_ghost.png", "cat_gift.png",
        "cat_grumpy.png", "cat_hungry.png", "cat_lady.png", "cat_laptop (2).png", "cat_laptop.png", "cat_makeup.png",
        "cat_mask.png", "cat_moustache.png", "cat_mummy.png", "cat_paper.png", "cat_pirate.png", "cat_plain.png",
        "cat_pumpkin.png", "cat_purr.png", "cat_radio.png", "cat_rascal.png", "cat_sing.png", "cat_sleep.png",
        "cat_slippers.png", "cat_smoke.png", "cat_tied.png", "cat_toilet.png", "cat_torture.png", "cat_upsidedown.png",
        "cat_vote.png", "cat_walk.png", "cat_wizard.png", "cat_yarn.png", "shadow_cat.png", "shadow_fly.png", "shadow_lady.png",
        "shadow_lion.png", "shadow_whale.png"};

    public static void cargarListas() {
        if (cargar) {
            recorrerCarpeta("airsendtfg/recursos/imagenes/gatos/64x64/", listaGatosPeque);
            recorrerCarpeta("airsendtfg/recursos/imagenes/gatos/128x128/", listaGatosMediano);
            recorrerCarpeta("airsendtfg/recursos/imagenes/gatos/256x256/", listaGatosGrande);
            cargar = false;
        }
    }

    private static void recorrerCarpeta(String carpeta, ArrayList<String> variable) {
        for(int i=0;i<listado.length;i++){
            variable.add(carpeta+listado[i]);
        }
    }

    public static String getGatoGrande(String nombre) {
        return getGato(nombre, listaGatosGrande);
    }

    public static String getGatoMediano(String nombre) {
        return getGato(nombre, listaGatosMediano);
    }

    public static String getGatoPeque(String nombre) {
        return getGato(nombre, listaGatosPeque);
    }

    public static ArrayList<String> getListaGatosGrande() {
        return listaGatosGrande;
    }

    public static ArrayList<String> getListaGatosMediano() {
        return listaGatosMediano;
    }

    public static ArrayList<String> getListaGatosPeque() {
        return listaGatosPeque;
    }

    private static String getGato(String nombre, ArrayList<String> tipo) {
        for (String elemento : tipo) {
            if (elemento.contains(nombre)) {
                return elemento;
            }
        }
        return null;
    }
}
