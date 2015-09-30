/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsendtfg;

import airsendtfg.frontend.LicenciaVentana;
import airsendtfg.frontend.nucleo.NucleoAirSend;
import airsendtfg.frontend.nucleo.negociacion.EmisorNegociacion;
import airsendtfg.librerias.nucleo.sondeo.MensajeSondeoJSON;
import airsendtfg.librerias.utilidades.Log;
import airsendtfg.recursos.Persistencia;

/**
 *
 * @author Pablo
 */
public class AirSendTFG {
    
    public void cargarAirSend(){
        if(!Persistencia.isLicencia()){
            new LicenciaVentana().setVisible(true);
        }
    }
    
    public static void pruebaSondeo1(){
        NucleoAirSend.cargarNucleos();
        MensajeSondeoJSON mensaje = new MensajeSondeoJSON();
        EmisorNegociacion.generarMensajeEmisorQ1(mensaje, null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello TFG!");
        Log.inicializar();
        pruebaSondeo1();
        //new AirSendTFG().cargarAirSend();
        // TODO code application logic here
        
        
        
    }
    
}
