/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsendtfg.frontend;

import airsendtfg.frontend.img.Colores;
import airsendtfg.frontend.nucleo.NucleoAirSend;
import airsendtfg.librerias.nucleo.sondeo.MensajeSondeoJSON;
import airsendtfg.librerias.nucleo.sondeo.NucleoSondeo;
import airsendtfg.librerias.nucleo.sondeo.ReceptorSondeo;
import airsendtfg.librerias.utilidades.Sistema;
import airsendtfg.recursos.Persistencia;
import airsendtfg.utilidades.FileDrop;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
public class MenuPrincipal extends javax.swing.JFrame {

    private Thread hiloWifiProgreso;
    private int x, y;
    private FileDrop dragAndDrop;
    

    /**
     * Creates new form menuPrincipal
     */
    public MenuPrincipal() {
        NucleoAirSend.cargarNucleos();
        this.esteticaBasica();
        this.hiloWifiProgreso();
        //this.cargarGridLayoutPrueba();
        hiloCargarLayout();
        System.out.println(Persistencia.getGatoUsuario());
    }

    /**
     * Método que ajusta la estética del front
     */
    private void esteticaBasica() {
        //Constructor de esta clase, inicializa
        this.setUndecorated(true); // Quita el borde del sistema operativo
        initComponents();
        this.setSize(750, 500); // Establece el tamaño de la ventana
        this.setResizable(false); // Evitamos que se pueda cambiar el tamaño de la ventana
        this.setLocationRelativeTo(null); // Centramos en la pantalla
        //this.getContentPane().setBackground(Colores.fondo()); // Color de fondo de ventana
        this.scrollFondo.setBackground(Colores.fondo());

    }

    /**
     * Esta clase genera un hilo anónimo para permitir animar la imagen del wifi
     */
    private void hiloWifiProgreso() {
        this.hiloWifiProgreso = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        labelProgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/frontend/img/wifiprogress/401.png")));
                        Thread.sleep(1000);
                        labelProgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/frontend/img/wifiprogress/402.png")));
                        Thread.sleep(1000);
                        labelProgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/frontend/img/wifiprogress/403.png")));
                        Thread.sleep(1000);
                        labelProgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/frontend/img/wifiprogress/404.png")));
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        //Log.error(ex.getLocalizedMessage());
                    }
                }
            }
        });
        this.hiloWifiProgreso.start();

    }

    //Los métodos cargarGridLayout y crearJPanelPrueba son métodos de prueba
    //de la interfaz
    /**
     * Método que permite cargar un GridLayout de prueba
     */
    private void cargarGridLayoutPrueba() {
        //Se establece un panel en 
        interiorScroll.setLayout(new GridLayout(5, 3, 3, 3));
        for (int i = 0; i < 12; i++) {
            interiorScroll.add(new Sistema("Fulanito","cat_banjo.png","192.168.1.50").getjPanel());
        }
    }

    private void cargarGridLayout(ArrayList<MensajeSondeoJSON> listaMensajes){
        interiorScroll.setLayout(new GridLayout(5,3,3,3));
        for(MensajeSondeoJSON mensaje:listaMensajes){
            interiorScroll.add(new Sistema(mensaje.getNombreUsuario(),"cat_banjo.png",mensaje.getNombreEquipo()).getjPanel());
        }
    }
    
    private void hiloCargarLayout(){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                                Thread.sleep(NucleoSondeo.tiempoSleppLoopSondeo);
                                cargarGridLayout(NucleoAirSend.getListaDispositivos());
                            while (true) {
                                cargarGridLayout(NucleoAirSend.getListaDispositivos());
                                Thread.sleep(NucleoSondeo.tiempoSleppLoopSondeo * 5);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ReceptorSondeo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
        ).start();
    }
    
    /**
     * Método para crear un JPanel para crear un objeto que representa a un
     * equipo
     *
     * @return
     * @throws IOException
     */
    private JPanel crearJPanelPrueba() throws IOException {
        JPanel objeto = new JPanel();
        //objeto.setSize(50, 100);
        objeto.setBackground(Color.red);
        //imagen
        BufferedImage myPicture = ImageIO.read(getClass().getResource("/airsendtfg/recursos/imagenes/ipad128.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        objeto.add(picLabel);

        JLabel texto = new JLabel();
        texto.setText("hola ");
        objeto.add(texto);

        this.dragAndDrop = new FileDrop(System.out, objeto, /*dragBorder,*/ new FileDrop.Listener() {
                    public void filesDropped(java.io.File[] files) {
                        // Código tras soltar archivos new EnviarFrame(lista.get(0),files).setVisible(true);
                        //Log.info("Archivo volcado al programa " + files.length + " " + files[0].getName());
                        System.err.println(files.length + " " + files[0].getName());
                    }
                });
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

        cabecera = new javax.swing.JPanel();
        panelCerrar = new javax.swing.JPanel();
        labelCerrar = new javax.swing.JLabel();
        panelMinimizar = new javax.swing.JPanel();
        labelMinimizar = new javax.swing.JLabel();
        panelConfiguracion = new javax.swing.JPanel();
        labelConfiguracion = new javax.swing.JLabel();
        panelProgreso = new javax.swing.JPanel();
        labelProgreso = new javax.swing.JLabel();
        nombrePrograma = new javax.swing.JLabel();
        scrollFondo = new javax.swing.JScrollPane();
        interiorScroll = new javax.swing.JPanel();
        barraInferior = new javax.swing.JPanel();
        labelBarraInferior = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(18, 23, 28));

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

        panelCerrar.setBackground(new java.awt.Color(102, 102, 102));
        panelCerrar.setPreferredSize(new java.awt.Dimension(40, 40));
        panelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCerrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelCerrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelCerrarMouseEntered(evt);
            }
        });

        labelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/frontend/img/ventana/cerrar.png"))); // NOI18N

        javax.swing.GroupLayout panelCerrarLayout = new javax.swing.GroupLayout(panelCerrar);
        panelCerrar.setLayout(panelCerrarLayout);
        panelCerrarLayout.setHorizontalGroup(
            panelCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCerrar)
        );
        panelCerrarLayout.setVerticalGroup(
            panelCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelMinimizar.setBackground(new java.awt.Color(102, 102, 102));
        panelMinimizar.setPreferredSize(new java.awt.Dimension(40, 40));
        panelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMinimizarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelMinimizarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelMinimizarMouseEntered(evt);
            }
        });

        labelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/frontend/img/ventana/minimizar.png"))); // NOI18N

        javax.swing.GroupLayout panelMinimizarLayout = new javax.swing.GroupLayout(panelMinimizar);
        panelMinimizar.setLayout(panelMinimizarLayout);
        panelMinimizarLayout.setHorizontalGroup(
            panelMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMinimizar)
        );
        panelMinimizarLayout.setVerticalGroup(
            panelMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelConfiguracion.setBackground(new java.awt.Color(102, 102, 102));
        panelConfiguracion.setPreferredSize(new java.awt.Dimension(40, 40));
        panelConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelConfiguracionMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelConfiguracionMouseEntered(evt);
            }
        });

        labelConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/frontend/img/ventana/config.png"))); // NOI18N

        javax.swing.GroupLayout panelConfiguracionLayout = new javax.swing.GroupLayout(panelConfiguracion);
        panelConfiguracion.setLayout(panelConfiguracionLayout);
        panelConfiguracionLayout.setHorizontalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelConfiguracion)
        );
        panelConfiguracionLayout.setVerticalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelProgreso.setBackground(new java.awt.Color(34, 35, 38));
        panelProgreso.setPreferredSize(new java.awt.Dimension(40, 40));
        panelProgreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelProgresoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelProgresoMouseEntered(evt);
            }
        });

        labelProgreso.setBackground(new java.awt.Color(18, 23, 28));

        javax.swing.GroupLayout panelProgresoLayout = new javax.swing.GroupLayout(panelProgreso);
        panelProgreso.setLayout(panelProgresoLayout);
        panelProgresoLayout.setHorizontalGroup(
            panelProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelProgreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        panelProgresoLayout.setVerticalGroup(
            panelProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        nombrePrograma.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        nombrePrograma.setForeground(new java.awt.Color(255, 255, 255));
        nombrePrograma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePrograma.setText("AirSend");

        javax.swing.GroupLayout cabeceraLayout = new javax.swing.GroupLayout(cabecera);
        cabecera.setLayout(cabeceraLayout);
        cabeceraLayout.setHorizontalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombrePrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        cabeceraLayout.setVerticalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(nombrePrograma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        interiorScroll.setBackground(new java.awt.Color(18, 23, 28));

        javax.swing.GroupLayout interiorScrollLayout = new javax.swing.GroupLayout(interiorScroll);
        interiorScroll.setLayout(interiorScrollLayout);
        interiorScrollLayout.setHorizontalGroup(
            interiorScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        interiorScrollLayout.setVerticalGroup(
            interiorScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        scrollFondo.setViewportView(interiorScroll);

        barraInferior.setBackground(new java.awt.Color(18, 23, 18));

        labelBarraInferior.setForeground(new java.awt.Color(255, 255, 255));
        labelBarraInferior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBarraInferior.setText("Buscando dipositivos en la red...");

        javax.swing.GroupLayout barraInferiorLayout = new javax.swing.GroupLayout(barraInferior);
        barraInferior.setLayout(barraInferiorLayout);
        barraInferiorLayout.setHorizontalGroup(
            barraInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelBarraInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        barraInferiorLayout.setVerticalGroup(
            barraInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelBarraInferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollFondo)
            .addComponent(barraInferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCerrarMouseEntered
        // TODO add your handling code here:
        this.panelCerrar.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_panelCerrarMouseEntered

    private void panelMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinimizarMouseEntered
        // TODO add your handling code here:
        this.panelMinimizar.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_panelMinimizarMouseEntered

    private void panelConfiguracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelConfiguracionMouseEntered
        // TODO add your handling code here:
        this.panelConfiguracion.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_panelConfiguracionMouseEntered

    private void panelProgresoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProgresoMouseEntered

    }//GEN-LAST:event_panelProgresoMouseEntered

    private void panelCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCerrarMouseExited
        // TODO add your handling code here:
        this.panelCerrar.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_panelCerrarMouseExited

    private void panelMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinimizarMouseExited
        // TODO add your handling code here:
        this.panelMinimizar.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_panelMinimizarMouseExited

    private void panelConfiguracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelConfiguracionMouseExited
        // TODO add your handling code here:
        this.panelConfiguracion.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_panelConfiguracionMouseExited

    private void panelProgresoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProgresoMouseExited

    }//GEN-LAST:event_panelProgresoMouseExited

    private void panelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }//GEN-LAST:event_panelCerrarMouseClicked

    private void panelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_panelMinimizarMouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraInferior;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel interiorScroll;
    private javax.swing.JLabel labelBarraInferior;
    private javax.swing.JLabel labelCerrar;
    private javax.swing.JLabel labelConfiguracion;
    private javax.swing.JLabel labelMinimizar;
    private javax.swing.JLabel labelProgreso;
    private javax.swing.JLabel nombrePrograma;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JPanel panelConfiguracion;
    private javax.swing.JPanel panelMinimizar;
    private javax.swing.JPanel panelProgreso;
    private javax.swing.JScrollPane scrollFondo;
    // End of variables declaration//GEN-END:variables
}