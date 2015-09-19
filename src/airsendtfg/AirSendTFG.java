/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsendtfg;

import airsendtfg.frontend.EnviarVentana;
import airsendtfg.frontend.MenuConfigInicial;
import airsendtfg.frontend.MenuInicial;
import airsendtfg.frontend.MenuPrincipal;
import airsendtfg.frontend.RecibirVentana;
import airsendtfg.librerias.nucleo.sondeo.NucleoSondeo;
import airsendtfg.librerias.nucleo.sondeo.ReceptorSondeo;

/**
 *
 * @author Pablo
 */
public class AirSendTFG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello TFG!");
        /*new MenuPrincipal().setVisible(true);
        new MenuInicial().setVisible(true);
        new MenuConfigInicial().setVisible(true);
        new EnviarVentana().setVisible(true);
        new RecibirVentana().setVisible(true);*/
        new NucleoSondeo();
        
    }
    
}
