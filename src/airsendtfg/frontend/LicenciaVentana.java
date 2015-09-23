/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


___________________________________________________________________

Los Proyectos fin de Grado son trabajos protegidos por la Ley de Propiedad 
Intelectual (Real Decreto Legislativo 1/1996, 12 abril), y en su caso por la 
Ley de patentes (Ley 11/1986, de 20 de marzo, de Patentes). 
En este sentido, por lo tanto, la titularidad de los derechos de propiedad
intelectual de los Proyectos Fin de Grado corresponde a los/las estudiantes
que los hayan realizado.

 */
package airsendtfg.frontend;

import airsendtfg.frontend.img.Colores;
import java.awt.MouseInfo;
import java.awt.Point;

/**
 *
 * @author Pablo
 */
public class LicenciaVentana extends javax.swing.JFrame {
    
    private int x, y;

    /**
     * Creates new form menuInicial
     */
    public LicenciaVentana() {
        this.esteticaBasica();
    }
    
    /**
     * Método que ajusta la estética del front
     */
    private void esteticaBasica(){
        //Constructor de esta clase, inicializa
        this.setUndecorated(true); // Quita el borde del sistema operativo
        initComponents();
        this.setSize(500, 680); // Establece el tamaño de la ventana
        this.setResizable(false); // Evitamos que se pueda cambiar el tamaño de la ventana
        this.setLocationRelativeTo(null); // Centramos en la pantalla
        this.textoCondiciones.setBackground(Colores.fondoClarito());
        this.aceptarContenedor.setBackground(Colores.cabeceraExited());
        this.cancelarContenedor.setBackground(Colores.cabeceraExited());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        contenedor = new javax.swing.JPanel();
        icono = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoCondiciones = new javax.swing.JTextArea();
        cancelarContenedor = new javax.swing.JPanel();
        cancelarLabel = new javax.swing.JLabel();
        aceptarContenedor = new javax.swing.JPanel();
        aceptarLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido a AirSend");

        contenedor.setBackground(new java.awt.Color(18, 23, 28));

        icono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/recursos/imagenes/iconoAirsend128.png"))); // NOI18N
        icono.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                iconoMouseDragged(evt);
            }
        });
        icono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconoMousePressed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Lucida Grande", 1, 25)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Bienvenido a AirSend");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Licencia y política de uso");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textoCondiciones.setColumns(20);
        textoCondiciones.setForeground(new java.awt.Color(255, 255, 255));
        textoCondiciones.setRows(5);
        textoCondiciones.setText("Esta obra es licenciada bajo Copyright (Todos los derechos reservados)\n\nAutor:\nJuan Pablo Toledo Gavagnin\njpablotoledo92@gmail.com\n\n___________________________________________________________________");
        jScrollPane1.setViewportView(textoCondiciones);

        cancelarContenedor.setBackground(new java.awt.Color(102, 102, 102));
        cancelarContenedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarContenedorMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelarContenedorMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelarContenedorMouseEntered(evt);
            }
        });

        cancelarLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        cancelarLabel.setForeground(new java.awt.Color(255, 255, 255));
        cancelarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelarLabel.setText("Cancelar");

        javax.swing.GroupLayout cancelarContenedorLayout = new javax.swing.GroupLayout(cancelarContenedor);
        cancelarContenedor.setLayout(cancelarContenedorLayout);
        cancelarContenedorLayout.setHorizontalGroup(
            cancelarContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelarContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        cancelarContenedorLayout.setVerticalGroup(
            cancelarContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelarContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        aceptarContenedor.setBackground(new java.awt.Color(102, 102, 102));
        aceptarContenedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarContenedorMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aceptarContenedorMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aceptarContenedorMouseEntered(evt);
            }
        });

        aceptarLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        aceptarLabel.setForeground(new java.awt.Color(255, 255, 255));
        aceptarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aceptarLabel.setText("Aceptar");

        javax.swing.GroupLayout aceptarContenedorLayout = new javax.swing.GroupLayout(aceptarContenedor);
        aceptarContenedor.setLayout(aceptarContenedorLayout);
        aceptarContenedorLayout.setHorizontalGroup(
            aceptarContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aceptarContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aceptarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );
        aceptarContenedorLayout.setVerticalGroup(
            aceptarContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aceptarContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aceptarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addComponent(cancelarContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptarContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aceptarContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelarContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
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

    private void iconoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_iconoMousePressed

    private void iconoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoMouseDragged
        // TODO add your handling code here:
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_iconoMouseDragged

    private void aceptarContenedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarContenedorMouseEntered
        // TODO add your handling code here:
        this.aceptarContenedor.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_aceptarContenedorMouseEntered

    private void aceptarContenedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarContenedorMouseExited
        // TODO add your handling code here:
        this.aceptarContenedor.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_aceptarContenedorMouseExited

    private void cancelarContenedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarContenedorMouseEntered
        // TODO add your handling code here:
        this.cancelarContenedor.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_cancelarContenedorMouseEntered

    private void cancelarContenedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarContenedorMouseExited
        // TODO add your handling code here:
        this.cancelarContenedor.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_cancelarContenedorMouseExited

    private void cancelarContenedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarContenedorMouseClicked
        // TODO add your handling code here:
        System.exit(0);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }//GEN-LAST:event_cancelarContenedorMouseClicked

    private void aceptarContenedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarContenedorMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuConfigInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_aceptarContenedorMouseClicked

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
            java.util.logging.Logger.getLogger(LicenciaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LicenciaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LicenciaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LicenciaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LicenciaVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aceptarContenedor;
    private javax.swing.JLabel aceptarLabel;
    private javax.swing.JPanel cancelarContenedor;
    private javax.swing.JLabel cancelarLabel;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textoCondiciones;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}