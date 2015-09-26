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
package airsendtfg.librerias.utilidades;

import airsendtfg.frontend.img.Colores;
import airsendtfg.recursos.imagenes.gatos.Gatos;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

/**
 *
 * @author Pablo
 */
public class Sistema {

    private String ip;
    private String nombre;
    private String imagen;
    private JPanel jPanel;
    private FileDrop dragAndDrop;
    
    /**
     * Clase constructora para generar un JPanel que represente a un dispositivo
     * @param nombre
     * @param imagen
     * @param ip 
     */
    public Sistema(String nombre, String imagen, String ip){
        try {
            this.nombre = nombre;
            this.imagen = imagen;
            this.ip = ip;
            this.cargarjPanel();
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Getter
    public JPanel getjPanel() {
        return jPanel;
    }

    /**
     * Método que carga la estética de un JPanel
     * @throws IOException 
     */
    private void cargarjPanel() throws IOException {
        this.jPanel = new JPanel();
        this.jPanel.setBackground(Colores.cabeceraExited());
        //Imagen en el JPanel
        Gatos.cargarListas();
        BufferedImage myPicture = ImageIO.read( ClassLoader.getSystemResource(Gatos.getGatoPeque(imagen)) );
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        this.jPanel.add(picLabel);

        //Configurando estética del JPanel
        JPanel contenedor = new JPanel();
        contenedor.setBackground(Colores.cabeceraExited());
        contenedor.setLayout(new GridLayout(2, 1, 3, 3));
        this.jPanel.add(contenedor);
        
        JLabel nombreDispositivo = new JLabel();
        nombreDispositivo.setText(nombre);
        nombreDispositivo.setForeground(Color.WHITE);
        contenedor.add(nombreDispositivo);
        
        JLabel ipDispositivo = new JLabel();
        ipDispositivo.setText(ip);
        ipDispositivo.setForeground(Color.WHITE);
        contenedor.add(ipDispositivo);
        
        //Comportamiento del ratón sobre el JPanel
        this.jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel.setBackground(Colores.cabeceraExited());
                jPanel.getComponent(1).setBackground(Colores.cabeceraExited());
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel.setBackground(Colores.cabeceraEntered());
                jPanel.getComponent(1).setBackground(Colores.cabeceraEntered());
            }
        });
        this.jPanel = this.jPanel;
    }

}
