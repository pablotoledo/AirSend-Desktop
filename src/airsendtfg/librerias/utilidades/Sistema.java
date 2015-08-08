/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import airsendtfg.utilidades.FileDrop;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.net.URL;

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

    public JPanel getjPanel() {
        return jPanel;
    }

    private void cargarjPanel() throws IOException {
        this.jPanel = new JPanel();

        this.jPanel.setBackground(Colores.cabeceraExited());
        //imagen
        Gatos.cargarListas();
        BufferedImage myPicture = ImageIO.read(Gatos.getGatoPeque(imagen).getAbsoluteFile());
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        this.jPanel.add(picLabel);

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

        this.dragAndDrop = new airsendtfg.utilidades.FileDrop(System.out, this.jPanel, /*dragBorder,*/ new airsendtfg.utilidades.FileDrop.Listener() {
                    public void filesDropped(java.io.File[] files) {
                        // Código tras soltar archivos new EnviarFrame(lista.get(0),files).setVisible(true);
                        //Log.info("Archivo volcado al programa " + files.length + " " + files[0].getName());
                        System.err.println(files.length + " " + files[0].getName());
                        
                    }
                });
        
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
