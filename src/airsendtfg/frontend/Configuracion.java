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
import airsendtfg.librerias.nucleo.negociacion.MensajeNegociacionJSON;
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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class Configuracion extends javax.swing.JFrame {

    private int x, y;
    private JPanel panelSeleccionado = new JPanel();
    private String gatoSeleccionado = "";
    private Map<JPanel, String> diccionarioJPanelString = new HashMap<JPanel, String>();

    /**
     * Creates new form Configuracion
     */
    public Configuracion() {
        this.setUndecorated(true); //Quitamos el borde del sistema operativo
        initComponents();
        this.setLocationRelativeTo(null); // Centramos en la pantalla
        this.cargarGridLayout();
        Persistencia.setNombreUsuario(Persistencia.getNombreUsuario());
        fieldRutaDescarga.setText(Persistencia.getRutaDescarga());
        nombreTextField.setText(Persistencia.getNombreUsuario());
        fieldRutaDescarga.setText(Persistencia.getRutaDescarga());
        this.confNombre.setText(confNombre.getText() + Persistencia.getNombreUsuario());
        this.confIcono.setText(confIcono.getText() + Persistencia.getGatoUsuario());
        this.confIDUsuario.setText(confIDUsuario.getText() + Persistencia.getIdUsuario());
        this.confRutaDescarga.setText(confRutaDescarga.getText() + Persistencia.getRutaDescarga());
        this.cargarJList();
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

    private void cargarPropiedadesPanelInterior(final JPanel panel) {
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //panel.setBackground(Colores.cabeceraExited());
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                //panel.setBackground(Colores.cabeceraEntered());
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //Cuando seleccionamos un elemento de la lista nos quedamos con el
                // en el caso de que otro elemento esté seleccionado previamente
                // contemplamos esta situación para que tenga otro color
                panelSeleccionado.setBackground(Colores.cabeceraExited());
                panel.setBackground(Colores.cabeceraEntered());
                panelSeleccionado = panel;
                gatoSeleccionado = diccionarioJPanelString.get(panel).substring(diccionarioJPanelString.get(panel).lastIndexOf("/") + 1, diccionarioJPanelString.get(panel).lastIndexOf("."));
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

    private void cargarJList() {
        Map<String, MensajeNegociacionJSON> listaDispositivos = Persistencia.getListaDispositivosConfianza();
        DefaultListModel modelo = new DefaultListModel();
        for (String key : listaDispositivos.keySet()) {
            String prueba = listaDispositivos.get(key).getIdentificadorEmisor();
            modelo.addElement(listaDispositivos.get(key).getNombreEmisor() + " " + listaDispositivos.get(key).getIdentificadorEmisor());
        }
        JListDispositivosConfianza.setModel(modelo);
        
    }

    private void eliminarDispositivoConfianza() {
        if (this.JListDispositivosConfianza.getSelectedValue() != null){
        String elemento = (String) this.JListDispositivosConfianza.getSelectedValue();
        elemento = elemento.substring(elemento.lastIndexOf(" ")+1, elemento.length());
        Persistencia.getListaDispositivosConfianza().remove(elemento);
        Persistencia.guardarPersistencia();
        this.JListDispositivosConfianza.removeAll();
        this.cargarJList();
        }
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
        tablero = new javax.swing.JTabbedPane();
        configuracionEquipo = new javax.swing.JPanel();
        scrollImagenPerfil = new javax.swing.JScrollPane();
        interiorScroll = new javax.swing.JPanel();
        titulo3 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        nombreTitulo = new javax.swing.JLabel();
        aceptar1 = new javax.swing.JPanel();
        aceptar1l = new javax.swing.JLabel();
        cancelar1 = new javax.swing.JPanel();
        cancelar1l = new javax.swing.JLabel();
        dispositivosConfianza = new javax.swing.JPanel();
        labelDispositivosConfianza = new javax.swing.JLabel();
        fieldRutaDescarga = new javax.swing.JTextField();
        cambiarCarpetaBox = new javax.swing.JPanel();
        cambiarCarpetaLabel = new javax.swing.JLabel();
        scrollJList = new javax.swing.JScrollPane();
        JListDispositivosConfianza = new javax.swing.JList();
        aceptar2 = new javax.swing.JPanel();
        aceptar1l1 = new javax.swing.JLabel();
        cancelar2 = new javax.swing.JPanel();
        cancelar1l1 = new javax.swing.JLabel();
        eliminarDispositivoConfianzaButtom = new javax.swing.JToggleButton();
        configuracionActual = new javax.swing.JPanel();
        confNombre = new javax.swing.JLabel();
        confIcono = new javax.swing.JLabel();
        confIDUsuario = new javax.swing.JLabel();
        confRutaDescarga = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.black);

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
        nombrePrograma.setText("Configuración de AirSend");

        javax.swing.GroupLayout cabeceraLayout = new javax.swing.GroupLayout(cabecera);
        cabecera.setLayout(cabeceraLayout);
        cabeceraLayout.setHorizontalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombrePrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cabeceraLayout.setVerticalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombrePrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablero.setBackground(new java.awt.Color(0, 0, 0));
        tablero.setForeground(new java.awt.Color(255, 255, 255));

        configuracionEquipo.setBackground(new java.awt.Color(18, 23, 28));

        scrollImagenPerfil.setBackground(new java.awt.Color(102, 102, 102));

        interiorScroll.setBackground(new java.awt.Color(18, 23, 28));

        javax.swing.GroupLayout interiorScrollLayout = new javax.swing.GroupLayout(interiorScroll);
        interiorScroll.setLayout(interiorScrollLayout);
        interiorScrollLayout.setHorizontalGroup(
            interiorScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );
        interiorScrollLayout.setVerticalGroup(
            interiorScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        scrollImagenPerfil.setViewportView(interiorScroll);

        titulo3.setForeground(new java.awt.Color(255, 255, 255));
        titulo3.setText("Selecciona un imagen para tu perfil");

        nombreTextField.setBackground(new java.awt.Color(102, 102, 102));
        nombreTextField.setForeground(new java.awt.Color(255, 255, 255));
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        nombreTitulo.setForeground(new java.awt.Color(255, 255, 255));
        nombreTitulo.setText("Un nombre para tu equipo:");

        aceptar1.setBackground(new java.awt.Color(102, 102, 102));

        aceptar1l.setForeground(new java.awt.Color(255, 255, 255));
        aceptar1l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aceptar1l.setText("Aceptar");
        aceptar1l.setToolTipText("");
        aceptar1l.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptar1lMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout aceptar1Layout = new javax.swing.GroupLayout(aceptar1);
        aceptar1.setLayout(aceptar1Layout);
        aceptar1Layout.setHorizontalGroup(
            aceptar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aceptar1l, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );
        aceptar1Layout.setVerticalGroup(
            aceptar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aceptar1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(aceptar1l, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cancelar1.setBackground(new java.awt.Color(102, 102, 102));

        cancelar1l.setForeground(new java.awt.Color(255, 255, 255));
        cancelar1l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelar1l.setText("Cancelar");
        cancelar1l.setToolTipText("");

        javax.swing.GroupLayout cancelar1Layout = new javax.swing.GroupLayout(cancelar1);
        cancelar1.setLayout(cancelar1Layout);
        cancelar1Layout.setHorizontalGroup(
            cancelar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelar1l, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );
        cancelar1Layout.setVerticalGroup(
            cancelar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelar1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cancelar1l, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout configuracionEquipoLayout = new javax.swing.GroupLayout(configuracionEquipo);
        configuracionEquipo.setLayout(configuracionEquipoLayout);
        configuracionEquipoLayout.setHorizontalGroup(
            configuracionEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracionEquipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(configuracionEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollImagenPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(configuracionEquipoLayout.createSequentialGroup()
                        .addGroup(configuracionEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreTitulo)
                            .addComponent(titulo3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nombreTextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracionEquipoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        configuracionEquipoLayout.setVerticalGroup(
            configuracionEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracionEquipoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(titulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollImagenPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(configuracionEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tablero.addTab("Configuración de usuario", configuracionEquipo);

        dispositivosConfianza.setBackground(new java.awt.Color(18, 23, 28));

        labelDispositivosConfianza.setForeground(new java.awt.Color(255, 255, 255));
        labelDispositivosConfianza.setText("Ruta donde se guardarán los archivos que envíen los dispositivos de confianza:");

        fieldRutaDescarga.setEditable(false);
        fieldRutaDescarga.setBackground(new java.awt.Color(102, 102, 102));
        fieldRutaDescarga.setForeground(new java.awt.Color(255, 255, 255));
        fieldRutaDescarga.setText("ruta de descarga");
        fieldRutaDescarga.setEnabled(false);
        fieldRutaDescarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRutaDescargaActionPerformed(evt);
            }
        });

        cambiarCarpetaBox.setBackground(new java.awt.Color(102, 102, 102));

        cambiarCarpetaLabel.setForeground(new java.awt.Color(255, 255, 255));
        cambiarCarpetaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cambiarCarpetaLabel.setText("Cambiar...");
        cambiarCarpetaLabel.setToolTipText("");
        cambiarCarpetaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarCarpetaLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout cambiarCarpetaBoxLayout = new javax.swing.GroupLayout(cambiarCarpetaBox);
        cambiarCarpetaBox.setLayout(cambiarCarpetaBoxLayout);
        cambiarCarpetaBoxLayout.setHorizontalGroup(
            cambiarCarpetaBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cambiarCarpetaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );
        cambiarCarpetaBoxLayout.setVerticalGroup(
            cambiarCarpetaBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cambiarCarpetaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scrollJList.setViewportView(JListDispositivosConfianza);

        aceptar2.setBackground(new java.awt.Color(102, 102, 102));

        aceptar1l1.setForeground(new java.awt.Color(255, 255, 255));
        aceptar1l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aceptar1l1.setText("Aceptar");
        aceptar1l1.setToolTipText("");

        javax.swing.GroupLayout aceptar2Layout = new javax.swing.GroupLayout(aceptar2);
        aceptar2.setLayout(aceptar2Layout);
        aceptar2Layout.setHorizontalGroup(
            aceptar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aceptar1l1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );
        aceptar2Layout.setVerticalGroup(
            aceptar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aceptar2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(aceptar1l1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cancelar2.setBackground(new java.awt.Color(102, 102, 102));

        cancelar1l1.setForeground(new java.awt.Color(255, 255, 255));
        cancelar1l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelar1l1.setText("Cancelar");
        cancelar1l1.setToolTipText("");

        javax.swing.GroupLayout cancelar2Layout = new javax.swing.GroupLayout(cancelar2);
        cancelar2.setLayout(cancelar2Layout);
        cancelar2Layout.setHorizontalGroup(
            cancelar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelar1l1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );
        cancelar2Layout.setVerticalGroup(
            cancelar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelar2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cancelar1l1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        eliminarDispositivoConfianzaButtom.setText("Eliminar como dispositivo de confianza");
        eliminarDispositivoConfianzaButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDispositivoConfianzaButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dispositivosConfianzaLayout = new javax.swing.GroupLayout(dispositivosConfianza);
        dispositivosConfianza.setLayout(dispositivosConfianzaLayout);
        dispositivosConfianzaLayout.setHorizontalGroup(
            dispositivosConfianzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dispositivosConfianzaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dispositivosConfianzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminarDispositivoConfianzaButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dispositivosConfianzaLayout.createSequentialGroup()
                        .addComponent(fieldRutaDescarga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cambiarCarpetaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollJList)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dispositivosConfianzaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dispositivosConfianzaLayout.createSequentialGroup()
                        .addComponent(labelDispositivosConfianza)
                        .addGap(0, 240, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dispositivosConfianzaLayout.setVerticalGroup(
            dispositivosConfianzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dispositivosConfianzaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDispositivosConfianza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dispositivosConfianzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cambiarCarpetaBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldRutaDescarga, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollJList, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarDispositivoConfianzaButtom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(dispositivosConfianzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tablero.addTab("Dispositivos de confianza", dispositivosConfianza);

        configuracionActual.setBackground(new java.awt.Color(18, 23, 28));

        confNombre.setForeground(new java.awt.Color(255, 255, 255));
        confNombre.setText("Nombre de usuario: ");

        confIcono.setForeground(new java.awt.Color(255, 255, 255));
        confIcono.setText("Icono de usuario: ");

        confIDUsuario.setForeground(new java.awt.Color(255, 255, 255));
        confIDUsuario.setText("ID de usuario: ");

        confRutaDescarga.setForeground(new java.awt.Color(255, 255, 255));
        confRutaDescarga.setText("Ruta de descarga: ");

        javax.swing.GroupLayout configuracionActualLayout = new javax.swing.GroupLayout(configuracionActual);
        configuracionActual.setLayout(configuracionActualLayout);
        configuracionActualLayout.setHorizontalGroup(
            configuracionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracionActualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(configuracionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confNombre)
                    .addComponent(confIcono)
                    .addComponent(confIDUsuario)
                    .addComponent(confRutaDescarga))
                .addContainerGap(618, Short.MAX_VALUE))
        );
        configuracionActualLayout.setVerticalGroup(
            configuracionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracionActualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confIcono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confIDUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confRutaDescarga)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        tablero.addTab("Ver configuración actual", configuracionActual);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablero, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablero))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCerrarMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_panelCerrarMouseClicked

    private void panelCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCerrarMouseExited
        // TODO add your handling code here:
        this.panelCerrar.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_panelCerrarMouseExited

    private void panelCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCerrarMouseEntered
        // TODO add your handling code here:
        this.panelCerrar.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_panelCerrarMouseEntered

    private void panelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_panelMinimizarMouseClicked

    private void panelMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinimizarMouseExited
        // TODO add your handling code here:
        this.panelMinimizar.setBackground(Colores.cabeceraExited());
    }//GEN-LAST:event_panelMinimizarMouseExited

    private void panelMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMinimizarMouseEntered
        // TODO add your handling code here:
        this.panelMinimizar.setBackground(Colores.cabeceraEntered());
    }//GEN-LAST:event_panelMinimizarMouseEntered

    private void cabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cabeceraMouseDragged
        // TODO add your handling code here:
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_cabeceraMouseDragged

    private void cabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cabeceraMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_cabeceraMousePressed

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void fieldRutaDescargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRutaDescargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRutaDescargaActionPerformed

    private void aceptar1lMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptar1lMouseClicked
        // TODO add your handling code here:
        if ((this.gatoSeleccionado.length() > 0) && (this.nombreTextField.getText().length() > 4)) {
            Persistencia.setNombreUsuario(this.nombreTextField.getText());
            Persistencia.setGatoUsuario(gatoSeleccionado);
            Persistencia.guardarPersistencia();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Es necesario que el nombre tenga al menos 5 letras y seleccione una imagen",
                    "Requisitos",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_aceptar1lMouseClicked

    private void eliminarDispositivoConfianzaButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarDispositivoConfianzaButtomActionPerformed
        // TODO add your handling code here:
        this.eliminarDispositivoConfianza();
    }//GEN-LAST:event_eliminarDispositivoConfianzaButtomActionPerformed

    private void cambiarCarpetaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarCarpetaLabelMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Escojer ruta de descarga");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Log.info("Ruta de descarga seleccionada");
            Log.info("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            Log.info("getSelectedFile() : "+ chooser.getSelectedFile());
            Persistencia.setRutaDescarga(""+chooser.getSelectedFile());
            Persistencia.guardarPersistencia();
            this.fieldRutaDescarga.setText(""+chooser.getSelectedFile());
        } else {
            Log.info("No se seleccionó ninguna ruta nueva de descarga por parte del usuario");
        }
    }//GEN-LAST:event_cambiarCarpetaLabelMouseClicked

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList JListDispositivosConfianza;
    private javax.swing.JPanel aceptar1;
    private javax.swing.JLabel aceptar1l;
    private javax.swing.JLabel aceptar1l1;
    private javax.swing.JPanel aceptar2;
    private javax.swing.JPanel cabecera;
    private javax.swing.JPanel cambiarCarpetaBox;
    private javax.swing.JLabel cambiarCarpetaLabel;
    private javax.swing.JPanel cancelar1;
    private javax.swing.JLabel cancelar1l;
    private javax.swing.JLabel cancelar1l1;
    private javax.swing.JPanel cancelar2;
    private javax.swing.JLabel confIDUsuario;
    private javax.swing.JLabel confIcono;
    private javax.swing.JLabel confNombre;
    private javax.swing.JLabel confRutaDescarga;
    private javax.swing.JPanel configuracionActual;
    private javax.swing.JPanel configuracionEquipo;
    private javax.swing.JPanel dispositivosConfianza;
    private javax.swing.JToggleButton eliminarDispositivoConfianzaButtom;
    private javax.swing.JTextField fieldRutaDescarga;
    private javax.swing.JPanel interiorScroll;
    private javax.swing.JLabel labelCerrar;
    private javax.swing.JLabel labelDispositivosConfianza;
    private javax.swing.JLabel labelMinimizar;
    private javax.swing.JLabel nombrePrograma;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JLabel nombreTitulo;
    private javax.swing.JPanel panelCerrar;
    private javax.swing.JPanel panelMinimizar;
    private javax.swing.JScrollPane scrollImagenPerfil;
    private javax.swing.JScrollPane scrollJList;
    private javax.swing.JTabbedPane tablero;
    private javax.swing.JLabel titulo3;
    // End of variables declaration//GEN-END:variables
}
