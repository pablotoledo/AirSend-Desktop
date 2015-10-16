/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsendtfg;

import airsendtfg.frontend.LicenciaVentana;
import airsendtfg.frontend.MenuPrincipal;
import airsendtfg.librerias.nucleo.NucleoAirSend;
import airsendtfg.librerias.nucleo.negociacion.EmisorNegociacion;
import airsendtfg.librerias.nucleo.sondeo.MensajeSondeoJSON;
import airsendtfg.librerias.utilidades.Log;
import airsendtfg.librerias.utilidades.Utilidades;
import airsendtfg.recursos.Persistencia;
import java.io.File;

/**
 *
 * @author Pablo
 */
public class AirSendTFG {
    
    public void cargarAirSend(){
        Utilidades.singleton();
        if(!Persistencia.existeFichero()){
            new LicenciaVentana().setVisible(true);
        }else{
            Persistencia.cargarPersistencia();
            new MenuPrincipal().setVisible(true);
        }
    }
    
    public static void pruebaSondeo1(){
        NucleoAirSend.cargarNucleos();
        MensajeSondeoJSON mensaje = new MensajeSondeoJSON();
        File archivo = new File("C:\\Users\\jtoledog\\Downloads\\azure.pdf");
        File[] archivos= new File[1];
        archivos[0]=archivo;
        EmisorNegociacion.generarMensajeEmisorQ1(mensaje, archivos);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello TFG!");
        Log.inicializar();
        //pruebaSondeo1();
        new AirSendTFG().cargarAirSend();
        // TODO code application logic here
        //new Configuracion().setVisible(true);
       
    }
    
}
