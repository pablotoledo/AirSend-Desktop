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
package airsendtfg.frontend;

import airsendtfg.frontend.img.Colores;
import airsendtfg.librerias.utilidades.Log;
import airsendtfg.recursos.Persistencia;
import airsendtfg.recursos.imagenes.gatos.Gatos;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class MenuConfigInicial extends javax.swing.JFrame {

    private int x, y;
    private JPanel panelSeleccionado = new JPanel();
    private String gatoSeleccionado ="";
    private Map<JPanel, String> diccionarioJPanelString = new HashMap<JPanel, String>();
    
    /**
     * Creates new form menuConfigInicial
     */
    public MenuConfigInicial() {
        this.esteticaBasica();

    }

    /**
     * Método que ajusta la estética del front
     */
    private void esteticaBasica() {
        //Constructor de esta clase, inicializa
        this.setUndecorated(true); // Quita el borde del sistema operativo
        initComponents();
        this.setSize(500, 680); // Establece el tamaño de la ventana
        this.setResizable(false); // Evitamos que se pueda cambiar el tamaño de la ventana
        this.setLocationRelativeTo(null); // Centramos en la pantalla
        this.cargarGridLayout();
    }

    private void cargarGridLayout() {
        //Se establece un panel en 
        interiorScroll.setLayout(new GridLayout(17, 3, 3, 3));
        for (String elemento : Gatos.getListaGatosPeque()) {
            try {
                JPanel panel = this.iconoUsuario(elemento);
                this.cargarPropiedadesPanelInterior(panel);
                this.diccionarioJPanelString.put(panel, elemento);
                interiorScroll.add(panel);
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void cargarPropiedadesPanelInterior(final JPanel panel){
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //panel.setBackground(Colores.cabeceraExited());
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                //panel.setBackground(Colores.cabeceraEntered());
            }
            public void mouseClicked(java.awt.event.MouseEvent evt){
                //Cuando seleccionamos un elemento de la lista nos quedamos con el
                // en el caso de que otro elemento esté seleccionado previamente
                // contemplamos esta situación para que tenga otro color
                panelSeleccionado.setBackground(Colores.cabeceraExited());
                panel.setBackground(Colores.cabeceraEntered());
                panelSeleccionado = panel;
                gatoSeleccionado = diccionarioJPanelString.get(panel).substring(diccionarioJPanelString.get(panel).lastIndexOf("/")+1,diccionarioJPanelString.get(panel).lastIndexOf("."));
            }
        });
    }

    private JPanel iconoUsuario(String ubicacion) throws IOException {
        JPanel objeto = new JPanel();
        //objeto.setSize(50, 100);
        objeto.setBackground(Colores.cabeceraExited());
        //imagen
        BufferedImage myPicture = ImageIO.read(ClassLoader.getSystemResource(ubicacion));
        // ImageIO.read( ClassLoader.getSystemResource(ubicacion) );
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);
        objeto.add(picLabel);
        return objeto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        cabecera = new javax.swing.JPanel();
        cabeceraLabel = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        nombreTitulo = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        titulo3 = new javax.swing.JLabel();
        scrollImagenPerfil = new javax.swing.JScrollPane();
        interiorScroll = new javax.swing.JPanel();
        panelBoton = new javax.swing.JPanel();
        labelAceptar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configuración de AirSend");

        contenedor.setBackground(new java.awt.Color(18, 23, 28));

        cabecera.setBackground(new java.awt.Color(34, 35, 38));
        cabecera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cabeceraMouseDragged(evt);
            }
        });
        cabecera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cabeceraMousePressed(evt);
            }
        });

        cabeceraLabel.setForeground(new java.awt.Color(255, 255, 255));
        cabeceraLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cabeceraLabel.setText("Configuración de AirSend");

        javax.swing.GroupLayout cabeceraLayout = new javax.swing.GroupLayout(cabecera);
        cabecera.setLayout(cabeceraLayout);
        cabeceraLayout.setHorizontalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cabeceraLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        cabeceraLayout.setVerticalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cabeceraLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titulo2.setForeground(new java.awt.Color(255, 255, 255));
        titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2.setText("Vamos a configurar AirSend para poder usarlo:");

        nombreTitulo.setForeground(new java.awt.Color(255, 255, 255));
        nombreTitulo.setText("Un nombre para tu equipo:");

        nombreTextField.setBackground(new java.awt.Color(102, 102, 102));
        nombreTextField.setForeground(new java.awt.Color(255, 255, 255));
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        titulo3.setForeground(new java.awt.Color(255, 255, 255));
        titulo3.setText("Selecciona un imagen para tu perfil");

        scrollImagenPerfil.setBackground(new java.awt.Color(102, 102, 102));

        interiorScroll.setBackground(new java.awt.Color(18, 23, 28));

        javax.swing.GroupLayout interiorScrollLayout = new javax.swing.GroupLayout(interiorScroll);
        interiorScroll.setLayout(interiorScrollLayout);
        interiorScrollLayout.setHorizontalGroup(
            interiorScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        interiorScrollLayout.setVerticalGroup(
            interiorScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        scrollImagenPerfil.setViewportView(interiorScroll);

        panelBoton.setBackground(new java.awt.Color(102, 102, 102));
        panelBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBotonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBotonMouseEntered(evt);
            }
        });

        labelAceptar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        labelAceptar.setForeground(new java.awt.Color(255, 255, 255));
        labelAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAceptar.setText("Aceptar");
        labelAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAceptarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAceptarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelAceptarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panelBotonLayout = new javax.swing.GroupLayout(panelBoton);
        panelBoton.setLayout(panelBotonLayout);
        panelBotonLayout.setHorizontalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBotonLayout.setVerticalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(scrollImagenPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                                .addComponent(panelBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombreTextField))
                            .addComponent(nombreTitulo)
                            .addComponent(titulo3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addComponent(cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titulo2)
                .addGap(18, 18, 18)
                .addComponent(nombreTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollImagenPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cabeceraMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_cabeceraMousePressed

    private void cabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cabeceraMouseDragged
        // TODO add your handling code here:
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_cabeceraMouseDragged

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void panelBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotonMouseEntered
        // TODO add your handling code here:
        this.panelBoton.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_panelBotonMouseEntered

    private void panelBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotonMouseExited
        // TODO add your handling code here:
        this.panelBoton.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_panelBotonMouseExited

    private void labelAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAceptarMouseClicked
        // TODO add your handling code here:
        if((this.gatoSeleccionado.length()>0)&&(this.nombreTextField.getText().length()>4)){
            Log.info(this.gatoSeleccionado+" "+this.nombreTextField.getText());
            this.setVisible(false);
            Persistencia.setGatoUsuario(gatoSeleccionado);
            Persistencia.setNombreUsuario(this.nombreTextField.getText());
            Persistencia.setLicencia(true);
            new MenuPrincipal().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_labelAceptarMouseClicked

    private void labelAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAceptarMouseEntered
        // TODO add your handling code here:
        this.panelBoton.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_labelAceptarMouseEntered

    private void labelAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAceptarMouseExited
        // TODO add your handling code here:
        this.panelBoton.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_labelAceptarMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuConfigInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuConfigInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuConfigInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuConfigInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuConfigInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cabecera;
    private javax.swing.JLabel cabeceraLabel;
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel interiorScroll;
    private javax.swing.JLabel labelAceptar;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JLabel nombreTitulo;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JScrollPane scrollImagenPerfil;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;
    // End of variables declaration//GEN-END:variables
}
