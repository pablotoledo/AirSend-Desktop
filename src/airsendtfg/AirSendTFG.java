/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsendtfg;

import airsendtfg.frontend.EnviarVentana;
import airsendtfg.frontend.MenuConfigInicial;
import airsendtfg.frontend.LicenciaVentana;
import airsendtfg.frontend.MenuPrincipal;
import airsendtfg.frontend.RecibirVentana;
import airsendtfg.librerias.nucleo.sondeo.NucleoSondeo;
import airsendtfg.librerias.nucleo.sondeo.ReceptorSondeo;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello TFG!");
        new AirSendTFG().cargarAirSend();
        // TODO code application logic here
        
        /*new MenuPrincipal().setVisible(true);
        new MenuInicial().setVisible(true);
        new MenuConfigInicial().setVisible(true);
        new EnviarVentana().setVisible(true);
        new RecibirVentana().setVisible(true);*/
        //new NucleoSondeo();
        
    }
    
}
