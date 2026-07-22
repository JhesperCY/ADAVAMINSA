package Controlador;

import Dao.DonativoDao;
import Dao.MedicinaDao;
import Dao.VoluntarioDao;
import Modelo.Medicina;
import Modelo.Usuario;
import Vista.FrmDonaciones;
import Vista.FrmInventario;
import Vista.FrmLogin;
import Vista.FrmPerfil;
import Vista.FrmPrincipal;
import Vista.FrmReportes;
import Vista.FrmVoluntarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrincipalController implements ActionListener{
    
    private final FrmPrincipal vista;
    private final Usuario usuario;

    private final MedicinaDao medicinaDao = new MedicinaDao();
    private final DonativoDao donativoDao = new DonativoDao();
    private final VoluntarioDao voluntarioDao = new VoluntarioDao();

    private JInternalFrame frameActivo;

    public PrincipalController(FrmPrincipal vista, Usuario usuario) {
        this.vista = vista;
        this.usuario = usuario;

        vista.getBtnInicio().addActionListener(this);
        vista.getBtnInventario().addActionListener(this);
        vista.getBtnDonaciones().addActionListener(this);
        vista.getBtnVoluntarios().addActionListener(this);
        vista.getBtnReportes().addActionListener(this);
        vista.getBtnPerfil().addActionListener(this);

        vista.getItemCerrarSesion().addActionListener(this);
        vista.getItemSalir().addActionListener(this);

        vista.getItemRegistrarMedicamento().addActionListener(this);
        vista.getItemRegistrarLote().addActionListener(this);
        vista.getItemBuscarMedicamento().addActionListener(this);

        vista.getItemNuevaDonacion().addActionListener(this);
        vista.getItemHistorial().addActionListener(this);

        vista.getItemRegistrarNuevoVoluntario().addActionListener(this);
        vista.getItemBuscarVoluntario().addActionListener(this);
        vista.getItemAsignarTarea().addActionListener(this);

        vista.getItemStock().addActionListener(this);
        vista.getItemMedicamentosProximosaVencer().addActionListener(this);
        vista.getItemDonaciones().addActionListener(this);
        vista.getItemVoluntarios().addActionListener(this);

        vista.getItemManual().addActionListener(this);
        vista.getItemAcercaDe().addActionListener(this);

        cargarResumen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();

        if (origen == vista.getBtnInicio()) {
            abrirInicio();
        } else if (origen == vista.getBtnInventario()
                || origen == vista.getItemRegistrarMedicamento()
                || origen == vista.getItemRegistrarLote()
                || origen == vista.getItemBuscarMedicamento()) {
            abrirInventario();
        } else if (origen == vista.getBtnDonaciones()
                || origen == vista.getItemNuevaDonacion()
                || origen == vista.getItemHistorial()) {
            abrirDonaciones();
        } else if (origen == vista.getBtnVoluntarios()
                || origen == vista.getItemRegistrarNuevoVoluntario()
                || origen == vista.getItemBuscarVoluntario()) {
            abrirVoluntarios();
        } else if (origen == vista.getBtnReportes()
                || origen == vista.getItemStock()
                || origen == vista.getItemMedicamentosProximosaVencer()
                || origen == vista.getItemDonaciones()
                || origen == vista.getItemVoluntarios()) {
            abrirReportes();
        } else if (origen == vista.getBtnPerfil()) {
            abrirPerfil();
        } else if (origen == vista.getItemAsignarTarea()) {
            JOptionPane.showMessageDialog(vista, "Funcionalidad de asignación de tareas (en desarrollo).");
        } else if (origen == vista.getItemCerrarSesion()) {
            cerrarSesion();
        } else if (origen == vista.getItemSalir()) {
            System.exit(0);
        } else if (origen == vista.getItemManual()) {
            JOptionPane.showMessageDialog(vista, "Manual de usuario (PDF) - en construcción.");
        } else if (origen == vista.getItemAcercaDe()) {
            JOptionPane.showMessageDialog(vista, "ADAVAMINSA v1.0\nUniversidad Tecnológica del Perú\nAnálisis y Diseño de Sistemas - 2026");
        }
    }

    private void mostrarModulo(JInternalFrame frame) {
        ocultarBienvenida();
        if (frameActivo != null) {
            vista.getDesktopPrincipal().remove(frameActivo);
        }
        frameActivo = frame;

        frame.setBounds(0, 0, vista.getDesktopPrincipal().getWidth(), vista.getDesktopPrincipal().getHeight());
        vista.getDesktopPrincipal().add(frame);
        frame.setVisible(true);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
            System.out.println(ex.toString());
        }
        frame.toFront();

        vista.getDesktopPrincipal().revalidate();
        vista.getDesktopPrincipal().repaint();
    }

    private void ocultarBienvenida() {
        vista.getJLabelBienvenida().setVisible(false);
        vista.getJPanelTotalMedicamentos().setVisible(false);
        vista.getJPanelDonacionesHoy().setVisible(false);
        vista.getJPanelVoluntariosActivos().setVisible(false);
    }

    private void mostrarBienvenida() {
        vista.getJLabelBienvenida().setVisible(true);
        vista.getJPanelTotalMedicamentos().setVisible(true);
        vista.getJPanelDonacionesHoy().setVisible(true);
        vista.getJPanelVoluntariosActivos().setVisible(true);
    }

    private void abrirInicio() {
        if (frameActivo != null) {
            vista.getDesktopPrincipal().remove(frameActivo);
            frameActivo = null;
        }
        mostrarBienvenida();
        cargarResumen();
        vista.getDesktopPrincipal().revalidate();
        vista.getDesktopPrincipal().repaint();
    }

    private void abrirInventario() {
        FrmInventario frm = new FrmInventario();
        new InventarioController(frm); // <- esto era lo que faltaba
        mostrarModulo(frm);
    }

    private void abrirDonaciones() {
        FrmDonaciones frm = new FrmDonaciones();
        new DonacionController(frm); // <- esto era lo que faltaba
        mostrarModulo(frm);
    }

    private void abrirVoluntarios() {
        FrmVoluntarios frm = new FrmVoluntarios();
        new VoluntarioController(frm); // <- esto era lo que faltaba
        mostrarModulo(frm);
    }

    private void abrirReportes() {
        FrmReportes frm = new FrmReportes();
        new ReporteController(frm); // <- esto era lo que faltaba
        mostrarModulo(frm);
    }

    private void abrirPerfil() {
        FrmPerfil frm = new FrmPerfil(usuario);
        new PerfilController(frm); // <- esta clase no existía
        mostrarModulo(frm);
    }

    private void cargarResumen() {
        List<Medicina> medicinas = medicinaDao.listarMedicinas();
        vista.getLblTotalMedicamentos().setText(String.valueOf(medicinas.size()));

        String hoy = LocalDate.now().toString();
        long donacionesHoy = donativoDao.listarHistorial().stream()
                .filter(d -> d.getFecha() != null && d.getFecha().startsWith(hoy))
                .count();
        vista.getLblDonacionesHoy().setText(String.valueOf(donacionesHoy));

        long voluntariosActivos = voluntarioDao.listarTodos().stream()
                .filter(v -> "Activo".equalsIgnoreCase(v.getEstado()))
                .count();
        vista.getLblVoluntariosActivos().setText(String.valueOf(voluntariosActivos));

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Medicamento", "Lote", "Vence", "Estado"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Medicina m : medicinaDao.listarPorVencer()) {
            modelo.addRow(new Object[]{m.getNombre(), m.getLote(), m.getFechaVencimiento(), "Por vencer"});
        }
        vista.getTblAlertas().setModel(modelo);
    }

    private void cerrarSesion() {
        vista.dispose();
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        new LoginController(login);
    }
    
}
