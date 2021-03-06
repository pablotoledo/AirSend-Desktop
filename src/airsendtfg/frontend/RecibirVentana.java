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

import airsendtfg.frontend.clasesAuxiliares.ActualizarRecibir;
import airsendtfg.frontend.img.Colores;
import airsendtfg.librerias.nucleo.negociacion.EmisorNegociacion;
import airsendtfg.librerias.nucleo.negociacion.MensajeNegociacionJSON;
import airsendtfg.librerias.nucleo.negociacion.NucleoNegociacion;
import airsendtfg.librerias.nucleo.transferencia.ReceptorTransferencia;
import airsendtfg.librerias.nucleo.sondeo.MensajeSondeoJSON;
import airsendtfg.librerias.nucleo.sondeo.NucleoSondeo;
import airsendtfg.librerias.utilidades.Log;
import airsendtfg.recursos.Persistencia;
import airsendtfg.recursos.imagenes.gatos.Gatos;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Pablo
 */
public class RecibirVentana extends javax.swing.JFrame {

    private int x, y;
    private MensajeNegociacionJSON entrada;
    private String estado = NucleoNegociacion.tipoMensajes[0];
    private ReceptorTransferencia receptor;
    private Thread hiloReceptor;
    private Thread hiloActualizarRecibir;
    private ActualizarRecibir actualizarRecibir;
    private String ruta;

    /**
     * Creates new form EnviarVentana
     *
     * @param entrada Mensaje JSON de entrada
     */
    public RecibirVentana(MensajeNegociacionJSON entrada) {
        this.entrada = entrada; //Asignamos info de entrada
        this.setUndecorated(true); // Quita el borde del sistema operativo
        initComponents();
        //this.setSize(750, 400); // Establece el tamaño de la ventana
        this.setResizable(false); // Evitamos que se pueda cambiar el tamaño de la ventana
        this.setLocationRelativeTo(null); // Centramos en la pantalla
        this.asignarGato();
        this.asignarValoresText(entrada.getNombreEmisor(), entrada.getIpEmisor(), Double.toString(entrada.getTamano()), Integer.toString(entrada.getListaElementos().length));
        this.barra.setMaximum((int) entrada.getTamano()*1024);
    }

    /**
     * Asignación de imagen de gato en la interfaz
     */
    private void asignarGato() {
        try {
            //Buscamos la imagen asociada al emisor, sino devolvemos una por defecto
            String gato = "cat_banjo.png";
            for (MensajeSondeoJSON emisor : NucleoSondeo.getListaElementos()) {
                if (emisor.getIdEmisor().equals(entrada.getIdentificadorEmisor())) {
                    gato = emisor.getIconoUsuario();
                }
            }
            BufferedImage myPicture = ImageIO.read(ClassLoader.getSystemResource(Gatos.getGatoPeque(gato)) );
            iconoDestino.removeAll();
            iconoDestino.setIcon(new ImageIcon(myPicture));
            revalidate();
            repaint();
        } catch (Exception ex) {
            Logger.getLogger(EnviarVentana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Asigna valores a los JLabel de la interfaz de usuario
     *
     * @param destinatario Nombre del emisor
     * @param ip IP del emisor
     * @param tamano Tamaño de los ficheros a recibir
     * @param narchivos Número de ficheros a recibir
     */
    public void asignarValoresText(String destinatario, String ip, String tamano, String narchivos) {
        this.textoDestinatario.setText("Nombre: " + destinatario);
        this.textoIP.setText("IP origen: " + ip);
        this.textoTamano.setText("Tamaño: " + tamano + " MB");
        this.textoNArchivos.setText("Nº Elementos: " + narchivos);
        this.textoEstado.setText("Estado: Propuesta recibida");
    }
    
    public void setTextoEstado(String textoEstado) {
        this.textoEstado.setText(textoEstado);
    }
    
    public void setValorBarra(int valor){
        this.barra.setValue(valor);
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setTextoBtnCancelar(String textoBtnCancelar) {
        this.textoBtnCancelar.setText(textoBtnCancelar);
    }

    public ReceptorTransferencia getReceptor() {
        return receptor;
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
        nombrePrograma = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
        iconoEnviar = new javax.swing.JLabel();
        textoTitulo1 = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JPanel();
        textoBtnEnviar = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JPanel();
        textoBtnCancelar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        textoDestinatario = new javax.swing.JLabel();
        textoIP = new javax.swing.JLabel();
        textoTamano = new javax.swing.JLabel();
        textoNArchivos = new javax.swing.JLabel();
        textoEstado = new javax.swing.JLabel();
        iconoDestino = new javax.swing.JLabel();
        checkConfiar = new javax.swing.JCheckBox();
        barra = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Propuesta recibida");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCerrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelCerrar))
        );
        panelCerrarLayout.setVerticalGroup(
            panelCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMinimizarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelMinimizar))
        );
        panelMinimizarLayout.setVerticalGroup(
            panelMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMinimizarLayout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(labelMinimizar))
        );

        nombrePrograma.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        nombrePrograma.setForeground(new java.awt.Color(255, 255, 255));
        nombrePrograma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePrograma.setText("Solicitud entrante");

        javax.swing.GroupLayout cabeceraLayout = new javax.swing.GroupLayout(cabecera);
        cabecera.setLayout(cabeceraLayout);
        cabeceraLayout.setHorizontalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabeceraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cabeceraLayout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(nombrePrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(94, 94, 94)))
        );
        cabeceraLayout.setVerticalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cabeceraLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(nombrePrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        contenedor.setBackground(new java.awt.Color(18, 23, 28));

        iconoEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/recursos/imagenes/ventanas/recibir.png"))); // NOI18N

        textoTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        textoTitulo1.setText("Un usuario desea enviarte algo:");

        botonEnviar.setBackground(new java.awt.Color(102, 102, 102));
        botonEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEnviarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEnviarMouseEntered(evt);
            }
        });

        textoBtnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        textoBtnEnviar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoBtnEnviar.setText("Recibir");
        textoBtnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoBtnEnviarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textoBtnEnviarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textoBtnEnviarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout botonEnviarLayout = new javax.swing.GroupLayout(botonEnviar);
        botonEnviar.setLayout(botonEnviarLayout);
        botonEnviarLayout.setHorizontalGroup(
            botonEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonEnviarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoBtnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        botonEnviarLayout.setVerticalGroup(
            botonEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonEnviarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoBtnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        botonCancelar.setBackground(new java.awt.Color(102, 102, 102));
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCancelarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCancelarMouseEntered(evt);
            }
        });

        textoBtnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        textoBtnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoBtnCancelar.setText("Cancelar");
        textoBtnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoBtnCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout botonCancelarLayout = new javax.swing.GroupLayout(botonCancelar);
        botonCancelar.setLayout(botonCancelarLayout);
        botonCancelarLayout.setHorizontalGroup(
            botonCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoBtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        botonCancelarLayout.setVerticalGroup(
            botonCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoBtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(18, 23, 28));

        textoDestinatario.setForeground(new java.awt.Color(255, 255, 255));
        textoDestinatario.setText("Nombre:");

        textoIP.setForeground(new java.awt.Color(255, 255, 255));
        textoIP.setText("IP origen:");

        textoTamano.setForeground(new java.awt.Color(255, 255, 255));
        textoTamano.setText("Tamaño: ");

        textoNArchivos.setForeground(new java.awt.Color(255, 255, 255));
        textoNArchivos.setText("Nº Archivos:");

        textoEstado.setForeground(new java.awt.Color(255, 255, 255));
        textoEstado.setText("Estado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textoDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoTamano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoNArchivos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addComponent(textoEstado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoDestinatario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoTamano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoNArchivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(textoEstado))
        );

        iconoDestino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airsendtfg/recursos/imagenes/gatos/64x64/cat_box.png"))); // NOI18N

        checkConfiar.setBackground(new java.awt.Color(18, 23, 28));
        checkConfiar.setForeground(new java.awt.Color(255, 255, 255));
        checkConfiar.setText("Confiar en este usuario en futuras ocasiones");
        checkConfiar.setBorder(null);
        checkConfiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkConfiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconoEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(iconoDestino)
                        .addGap(105, 105, 105))
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contenedorLayout.createSequentialGroup()
                                .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(contenedorLayout.createSequentialGroup()
                                .addComponent(textoTitulo1)
                                .addGap(114, 114, 114)))
                        .addContainerGap(157, Short.MAX_VALUE))
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkConfiar, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconoEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(textoTitulo1)
                        .addGap(18, 18, 18)
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconoDestino))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkConfiar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cabecera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCerrarMouseClicked
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_panelCerrarMouseClicked

    private void panelCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCerrarMouseExited
        this.panelCerrar.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_panelCerrarMouseExited

    private void panelCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCerrarMouseEntered
        this.panelCerrar.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_panelCerrarMouseEntered

    private void panelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_panelMinimizarMouseClicked

    private void panelMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinimizarMouseExited
        this.panelMinimizar.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_panelMinimizarMouseExited

    private void panelMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinimizarMouseEntered
        this.panelMinimizar.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_panelMinimizarMouseEntered

    private void botonCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseEntered
        this.botonCancelar.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_botonCancelarMouseEntered

    private void botonCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseExited
        this.botonCancelar.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_botonCancelarMouseExited

    private void botonEnviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEnviarMouseEntered
        this.botonEnviar.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_botonEnviarMouseEntered

    private void botonEnviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEnviarMouseExited
        this.botonEnviar.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_botonEnviarMouseExited

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        this.setVisible(false);
        this.hiloReceptor.interrupt();
        this.dispose();
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void cabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cabeceraMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_cabeceraMouseDragged

    private void cabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cabeceraMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_cabeceraMousePressed

    private void textoBtnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoBtnEnviarMouseClicked
        if (estado.equals(NucleoNegociacion.tipoMensajes[0])) {
            //Invocamos a JFileChooser para permitir al usuario elegir donde
            //guardar los archivos
            JFileChooser chooser = new JFileChooser();
            //Establecemos propiedades
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Selecciona carpeta de destino");
            chooser.setApproveButtonText("Seleccionar");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.ruta = chooser.getCurrentDirectory() + "/" + chooser.getSelectedFile().getName() + "/";
                chooser.setAcceptAllFileFilterUsed(false);
                this.receptor = new ReceptorTransferencia(entrada);
                this.receptor.setRutaFichero(ruta);
                this.hiloReceptor = new Thread(this.receptor);
                this.hiloReceptor.start();
                this.actualizarRecibir = new ActualizarRecibir(this,this.entrada);
                this.hiloActualizarRecibir = new Thread(this.actualizarRecibir);
                this.hiloActualizarRecibir.start();
                EmisorNegociacion.enviarMensajeAceptadoQ1(entrada, this.receptor.getPuerto());
                this.textoEstado.setText("Estado: Propuesta aceptada");
            }
            if(this.checkConfiar.isSelected()){
                Persistencia.getListaDispositivosConfianza().put(entrada.getIdentificadorEmisor(), entrada);
                Persistencia.guardarPersistencia();
                Log.info("Añadido "+entrada.getIdentificadorEmisor()+" a la lista de dipositivos de confianza");
            }
            this.textoBtnEnviar.setForeground(Colores.cabeceraExited());
        }
        this.estado = entrada.getTipoMensaje();
    }//GEN-LAST:event_textoBtnEnviarMouseClicked

    private void checkConfiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkConfiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkConfiarActionPerformed

    private void textoBtnEnviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoBtnEnviarMouseEntered
        this.botonEnviar.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_textoBtnEnviarMouseEntered

    private void textoBtnEnviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoBtnEnviarMouseExited
        this.botonEnviar.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_textoBtnEnviarMouseExited

    private void textoBtnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoBtnCancelarMouseClicked
        this.hiloActualizarRecibir.interrupt();
    }//GEN-LAST:event_textoBtnCancelarMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JPanel botonCancelar;
    private javax.swing.JPanel botonEnviar;
    private javax.swing.JPanel cabecera;
    private javax.swing.JCheckBox checkConfiar;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel iconoDestino;
    private javax.swing.JLabel iconoEnviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCerrar;
    private javax.swing.JLabel labelMinimizar;
    private javax.swing.JLabel nombrePrograma;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JPanel panelMinimizar;
    private javax.swing.JLabel textoBtnCancelar;
    private javax.swing.JLabel textoBtnEnviar;
    private javax.swing.JLabel textoDestinatario;
    private javax.swing.JLabel textoEstado;
    private javax.swing.JLabel textoIP;
    private javax.swing.JLabel textoNArchivos;
    private javax.swing.JLabel textoTamano;
    private javax.swing.JLabel textoTitulo1;
    // End of variables declaration//GEN-END:variables
}
