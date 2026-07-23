package Vista;

import Controlador.LoginController;
import Controlador.PrincipalController;
import Modelo.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class FrmPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPrincipal.class.getName());

    private Usuario usuarioActual;

    public FrmPrincipal(Usuario usuario) {
        this.usuarioActual = usuario;
        initComponents();
        desktopPrincipal.setLayout(null);
        configurarDatos();
        iniciarFecha();
        iniciarHora();
        new PrincipalController(this, usuarioActual);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Vista/Imagenes/icono_adavaminsa.ico"));
        System.out.println(getClass().getResource("/Vista/Imagenes/icono_adavaminsa.ico"));
        return retValue;
    }

    private void configurarDatos() {
        this.lblUsuario.setText(usuarioActual.getNombre());
        this.lblRol.setText(usuarioActual.getRol());
        jLabel1.setText("Bienvenido(a) " + usuarioActual.getNombre());
        this.setTitle("ADAVAMINSA - " + usuarioActual.getNombre() + " (" + usuarioActual.getRol() + ")");
    }
    
    private void iniciarFecha() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        lblFecha.setText(formato.format(new Date()));
    }
    
    private void iniciarHora() {
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat formatoHora
                    = new SimpleDateFormat("HH:mm:ss");
            lblHora.setText(formatoHora.format(new Date()));
        });
        timer.start();
    }
    
    // Botones del menú lateral
    public javax.swing.JButton getBtnInicio() {
        return btnInicio;
    }

    public javax.swing.JButton getBtnInventario() {
        return btnInventario;
    }

    public javax.swing.JButton getBtnDonaciones() {
        return btnDonaciones;
    }

    public javax.swing.JButton getBtnVoluntarios() {
        return btnVoluntarios;
    }

    public javax.swing.JButton getBtnReportes() {
        return btnReportes;
    }

    public javax.swing.JButton getBtnPerfil() {
        return btnPerfil;
    }
    
    public javax.swing.JMenuItem getItemCerrarSesion() {
        return itemCerrarSesion;
    }

    public javax.swing.JMenuItem getItemSalir() {
        return itemSalir;
    }

    public javax.swing.JMenuItem getItemRegistrarMedicamento() {
        return itemRegistrarMedicamento;
    }

    public javax.swing.JMenuItem getItemRegistrarLote() {
        return itemRegistrarLote;
    }

    public javax.swing.JMenuItem getItemBuscarMedicamento() {
        return itemBuscarMedicamento;
    }

    public javax.swing.JMenuItem getItemNuevaDonacion() {
        return itemNuevaDonacion;
    }

    public javax.swing.JMenuItem getItemHistorial() {
        return itemHistorial;
    }

    public javax.swing.JMenuItem getItemRegistrarNuevoVoluntario() {
        return itemRegistrarNuevoVoluntario;
    }

    public javax.swing.JMenuItem getItemBuscarVoluntario() {
        return itemBuscarVoluntario;
    }

    public javax.swing.JMenuItem getItemAsignarTarea() {
        return itemAsignarTarea;
    }

    public javax.swing.JMenuItem getItemStock() {
        return itemStock;
    }

    public javax.swing.JMenuItem getItemMedicamentosProximosaVencer() {
        return itemMedicamentosProximosaVencer;
    }

    public javax.swing.JMenuItem getItemDonaciones() {
        return itemDonaciones;
    }

    public javax.swing.JMenuItem getItemVoluntarios() {
        return itemVoluntarios;
    }

    public javax.swing.JMenuItem getItemManual() {
        return itemManual;
    }

    public javax.swing.JMenuItem getItemAcercaDe() {
        return itemAcercaDe;
    }
    
    public javax.swing.JDesktopPane getDesktopPrincipal() {
        return desktopPrincipal;
    }
    
    public javax.swing.JLabel getJLabelBienvenida() {
        return jLabel1; // el que dice "BIENVENIDO AL SISTEMA"
    }

    public javax.swing.JPanel getJPanelTotalMedicamentos() {
        return jPanel3;
    }

    public javax.swing.JPanel getJPanelDonacionesHoy() {
        return jPanel5;
    }

    public javax.swing.JPanel getJPanelVoluntariosActivos() {
        return jPanel6;
    }

    public javax.swing.JLabel getLblTotalMedicamentos() {
        return lblTotalMedicamentos;
    }

    public javax.swing.JLabel getLblDonacionesHoy() {
        return lblDonacionesHoy;
    }

    public javax.swing.JLabel getLblVoluntariosActivos() {
        return lblVoluntariosActivos;
    }

    public javax.swing.JTable getTblAlertas() {
        return tblAlertas;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUsu = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblLogoAdavaminsa = new javax.swing.JLabel();
        lblRo = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblHo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblfe = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnDonaciones = new javax.swing.JButton();
        btnVoluntarios = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        desktopPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalMedicamentos = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblDonacionesHoy = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblVoluntariosActivos = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        scrollAlertas = new javax.swing.JScrollPane();
        tblAlertas = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuIcono = new javax.swing.JMenu();
        menuArchivo = new javax.swing.JMenu();
        itemCerrarSesion = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        menuInventario = new javax.swing.JMenu();
        itemRegistrarMedicamento = new javax.swing.JMenuItem();
        itemRegistrarLote = new javax.swing.JMenuItem();
        itemBuscarMedicamento = new javax.swing.JMenuItem();
        menuDonacion = new javax.swing.JMenu();
        itemNuevaDonacion = new javax.swing.JMenuItem();
        itemHistorial = new javax.swing.JMenuItem();
        menuVoluntario = new javax.swing.JMenu();
        itemRegistrarNuevoVoluntario = new javax.swing.JMenuItem();
        itemBuscarVoluntario = new javax.swing.JMenuItem();
        itemAsignarTarea = new javax.swing.JMenuItem();
        menuReporte = new javax.swing.JMenu();
        itemStock = new javax.swing.JMenuItem();
        itemMedicamentosProximosaVencer = new javax.swing.JMenuItem();
        itemDonaciones = new javax.swing.JMenuItem();
        itemVoluntarios = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        itemManual = new javax.swing.JMenuItem();
        itemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsu.setText("Usuario:");
        jPanel1.add(lblUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        lblUsuario.setText("................");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));
        jPanel1.add(lblLogoAdavaminsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

        lblRo.setText("Rol:");
        jPanel1.add(lblRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        lblRol.setText("................");
        jPanel1.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        lblHora.setText("................");
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        lblHo.setText("Hora:");
        jPanel1.add(lblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, -1, -1));

        lblFecha.setText("................");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        lblfe.setText("Fecha");
        jPanel1.add(lblfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 40));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setText("Inicio");
        jPanel2.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 48));

        btnInventario.setText("Inventario");
        jPanel2.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 270, 48));

        btnDonaciones.setText("Donaciones");
        jPanel2.add(btnDonaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 270, 48));

        btnVoluntarios.setText("Voluntarios");
        jPanel2.add(btnVoluntarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 270, 48));

        btnReportes.setText("Reportes");
        jPanel2.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 270, 48));

        btnPerfil.setText("Mi Perfil");
        jPanel2.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 270, 48));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 270, 310));

        desktopPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO AL SISTEMA");
        desktopPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 310, 40));

        jLabel2.setText("Total de Medicamentos:");

        lblTotalMedicamentos.setText(".............");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblTotalMedicamentos)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTotalMedicamentos))
                .addGap(25, 25, 25))
        );

        desktopPrincipal.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 430, 70));

        jLabel4.setText("Donaciones de Hoy:");

        lblDonacionesHoy.setText(".............");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblDonacionesHoy)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblDonacionesHoy))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        desktopPrincipal.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 430, 80));

        jLabel6.setText("Voluntarios Activos:");

        lblVoluntariosActivos.setText(".............");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblVoluntariosActivos)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblVoluntariosActivos))
                .addGap(26, 26, 26))
        );

        desktopPrincipal.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 430, 70));

        getContentPane().add(desktopPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 640, 350));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        jLabel8.setText("Alertas del Sistema");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tblAlertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Medicamento", "Lote", "Vence", "Estado"
            }
        ));
        tblAlertas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblAlertas.setShowGrid(false);
        tblAlertas.setShowHorizontalLines(true);
        tblAlertas.setShowVerticalLines(true);
        scrollAlertas.setViewportView(tblAlertas);

        jPanel4.add(scrollAlertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 940, 150));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 960, 190));

        menuIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/icono_pestaña.png"))); // NOI18N
        menuIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMenuBar1.add(menuIcono);

        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        menuArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuArchivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuArchivo.setPreferredSize(new java.awt.Dimension(160, 40));

        itemCerrarSesion.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemCerrarSesion.setText("Cerrar Sesión");
        menuArchivo.add(itemCerrarSesion);

        itemSalir.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemSalir.setText("Salir");
        menuArchivo.add(itemSalir);

        jMenuBar1.add(menuArchivo);

        menuInventario.setText("Inventario");
        menuInventario.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        menuInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuInventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuInventario.setPreferredSize(new java.awt.Dimension(160, 40));

        itemRegistrarMedicamento.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemRegistrarMedicamento.setText("Registro de Medicamento");
        menuInventario.add(itemRegistrarMedicamento);

        itemRegistrarLote.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemRegistrarLote.setText("Registrar Lote");
        menuInventario.add(itemRegistrarLote);

        itemBuscarMedicamento.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemBuscarMedicamento.setText("Buscar Medicamento");
        menuInventario.add(itemBuscarMedicamento);

        jMenuBar1.add(menuInventario);

        menuDonacion.setText("Donación");
        menuDonacion.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        menuDonacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuDonacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuDonacion.setPreferredSize(new java.awt.Dimension(160, 40));

        itemNuevaDonacion.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemNuevaDonacion.setText("Nueva Donación");
        menuDonacion.add(itemNuevaDonacion);

        itemHistorial.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemHistorial.setText("Historial");
        menuDonacion.add(itemHistorial);

        jMenuBar1.add(menuDonacion);

        menuVoluntario.setText("Voluntarios");
        menuVoluntario.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        menuVoluntario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuVoluntario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuVoluntario.setPreferredSize(new java.awt.Dimension(160, 40));

        itemRegistrarNuevoVoluntario.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemRegistrarNuevoVoluntario.setText("Registrar Nuevo Voluntario");
        menuVoluntario.add(itemRegistrarNuevoVoluntario);

        itemBuscarVoluntario.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemBuscarVoluntario.setText("Buscar Voluntario");
        menuVoluntario.add(itemBuscarVoluntario);

        itemAsignarTarea.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemAsignarTarea.setText("Asignar Tareas");
        menuVoluntario.add(itemAsignarTarea);

        jMenuBar1.add(menuVoluntario);

        menuReporte.setText("Reportes");
        menuReporte.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        menuReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuReporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuReporte.setPreferredSize(new java.awt.Dimension(160, 40));

        itemStock.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemStock.setText("Stock");
        menuReporte.add(itemStock);

        itemMedicamentosProximosaVencer.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemMedicamentosProximosaVencer.setText("Medicamentos Proximos a Vencer");
        menuReporte.add(itemMedicamentosProximosaVencer);

        itemDonaciones.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemDonaciones.setText("Donaciones");
        menuReporte.add(itemDonaciones);

        itemVoluntarios.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemVoluntarios.setText("Voluntarios");
        menuReporte.add(itemVoluntarios);

        jMenuBar1.add(menuReporte);

        menuAyuda.setText("Ayuda");
        menuAyuda.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        menuAyuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuAyuda.setPreferredSize(new java.awt.Dimension(160, 40));

        itemManual.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemManual.setText("Manual");
        menuAyuda.add(itemManual);

        itemAcercaDe.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        itemAcercaDe.setText("Acerca de");
        menuAyuda.add(itemAcercaDe);

        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FrmLogin login = new FrmLogin();
            login.setVisible(true);
            new LoginController(login);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonaciones;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnVoluntarios;
    private javax.swing.JDesktopPane desktopPrincipal;
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenuItem itemAsignarTarea;
    private javax.swing.JMenuItem itemBuscarMedicamento;
    private javax.swing.JMenuItem itemBuscarVoluntario;
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemDonaciones;
    private javax.swing.JMenuItem itemHistorial;
    private javax.swing.JMenuItem itemManual;
    private javax.swing.JMenuItem itemMedicamentosProximosaVencer;
    private javax.swing.JMenuItem itemNuevaDonacion;
    private javax.swing.JMenuItem itemRegistrarLote;
    private javax.swing.JMenuItem itemRegistrarMedicamento;
    private javax.swing.JMenuItem itemRegistrarNuevoVoluntario;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemStock;
    private javax.swing.JMenuItem itemVoluntarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblDonacionesHoy;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblLogoAdavaminsa;
    private javax.swing.JLabel lblRo;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTotalMedicamentos;
    private javax.swing.JLabel lblUsu;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVoluntariosActivos;
    private javax.swing.JLabel lblfe;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuDonacion;
    private javax.swing.JMenu menuIcono;
    private javax.swing.JMenu menuInventario;
    private javax.swing.JMenu menuReporte;
    private javax.swing.JMenu menuVoluntario;
    private javax.swing.JScrollPane scrollAlertas;
    private javax.swing.JTable tblAlertas;
    // End of variables declaration//GEN-END:variables
}
