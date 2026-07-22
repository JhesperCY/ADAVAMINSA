package Controlador;

import Dao.DonativoDao;
import Dao.HospitalDao;
import Dao.MedicinaDao;
import Dao.TareaDao;
import Dao.VoluntarioDao;
import Modelo.Hospital;
import Modelo.Medicina;
import Modelo.Tarea;
import Modelo.Usuario;
import Modelo.Voluntario;
import Vista.FrmDonaciones;
import Vista.FrmInventario;
import Vista.FrmLogin;
import Vista.FrmPerfil;
import Vista.FrmPrincipal;
import Vista.FrmReportes;
import Vista.FrmVoluntarios;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

public class PrincipalController implements ActionListener{
    
    private final FrmPrincipal vista;
    private final Usuario usuario;

    private final MedicinaDao medicinaDao = new MedicinaDao();
    private final DonativoDao donativoDao = new DonativoDao();
    private final VoluntarioDao voluntarioDao = new VoluntarioDao();
    private final HospitalDao hospitalDao = new HospitalDao();
    private final TareaDao tareaDao = new TareaDao();

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

        aplicarPermisosSegunRol();
        cargarResumen();
    }
    private void aplicarPermisosSegunRol() {
        boolean puedeInventario = puedeAcceder("Inventario");
        boolean puedeVoluntarios = puedeAcceder("Voluntarios");
        // Donaciones, Reportes y Perfil quedan disponibles para los tres roles.

        vista.getBtnInventario().setEnabled(puedeInventario);
        vista.getItemRegistrarMedicamento().setEnabled(puedeInventario);
        vista.getItemRegistrarLote().setEnabled(puedeInventario);
        vista.getItemBuscarMedicamento().setEnabled(puedeInventario);

        vista.getBtnVoluntarios().setEnabled(puedeVoluntarios);
        vista.getItemRegistrarNuevoVoluntario().setEnabled(puedeVoluntarios);
        vista.getItemBuscarVoluntario().setEnabled(puedeVoluntarios);
        vista.getItemAsignarTarea().setEnabled(puedeVoluntarios);
    }

    private boolean puedeAcceder(String modulo) {
        String rol = usuario.getRol();
        boolean esAdmin = "Administradora".equalsIgnoreCase(rol);
        boolean esAlmacen = "Almacén".equalsIgnoreCase(rol) || "Almacen".equalsIgnoreCase(rol);
        boolean esCoordinadora = "Coordinadora".equalsIgnoreCase(rol);

        return switch (modulo) {
            case "Inventario" ->
                esAdmin || esAlmacen;
            case "Voluntarios" ->
                esAdmin || esCoordinadora;
            default ->
                true;
        };
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
            asignarTarea();
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

        frame.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent evt) {
                if (frameActivo == evt.getInternalFrame()) {
                    frameActivo = null;
                }
                mostrarBienvenida();
                cargarResumen();
                vista.getDesktopPrincipal().revalidate();
                vista.getDesktopPrincipal().repaint();
            }
        });

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
        if (!tienePermiso("Inventario")) {
            return;
        }
        mostrarModulo(new FrmInventario());
    }

    private void abrirDonaciones() {
        mostrarModulo(new FrmDonaciones());
    }

    private void abrirVoluntarios() {
        if (!tienePermiso("Voluntarios")) {
            return;
        }
        mostrarModulo(new FrmVoluntarios());
    }

    private boolean tienePermiso(String modulo) {
        boolean permitido = puedeAcceder(modulo);
        if (!permitido) {
            JOptionPane.showMessageDialog(vista,
                    "Tu rol (" + usuario.getRol() + ") no tiene acceso al módulo de " + modulo + ".",
                    "Acceso restringido", JOptionPane.WARNING_MESSAGE);
        }
        return permitido;
    }

    private void abrirReportes() {
        mostrarModulo(new FrmReportes());
    }

    private void abrirPerfil() {
        mostrarModulo(new FrmPerfil(usuario));
    }

    private void asignarTarea() {
        List<Voluntario> voluntarios = voluntarioDao.listarTodos();
        List<Hospital> hospitales = hospitalDao.listarTodos();
        if (voluntarios.isEmpty() || hospitales.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "Se necesita al menos un voluntario y un hospital registrados.");
            return;
        }

        JComboBox<String> cbxVoluntario = new JComboBox<>();
        for (Voluntario v : voluntarios) {
            cbxVoluntario.addItem(v.getIdVoluntario() + " - " + v.getNombre() + " " + v.getApellido());
        }
        JComboBox<String> cbxHospitalTarea = new JComboBox<>();
        for (Hospital h : hospitales) {
            cbxHospitalTarea.addItem(h.getIdHospital() + " - " + h.getNombre());
        }
        JTextField txtFecha = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
        JTextField txtHora = new JTextField("09:00");
        JTextField txtDescripcion = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Voluntario:"));
        panel.add(cbxVoluntario);
        panel.add(new JLabel("Hospital:"));
        panel.add(cbxHospitalTarea);
        panel.add(new JLabel("Fecha (AAAA-MM-DD):"));
        panel.add(txtFecha);
        panel.add(new JLabel("Hora:"));
        panel.add(txtHora);
        panel.add(new JLabel("Descripción de la labor:"));
        panel.add(txtDescripcion);

        int opcion = JOptionPane.showConfirmDialog(vista, panel, "Asignar tarea asistencial", JOptionPane.OK_CANCEL_OPTION);
        if (opcion != JOptionPane.OK_OPTION) {
            return;
        }
        if (txtDescripcion.getText().isBlank()) {
            JOptionPane.showMessageDialog(vista, "Describa la labor asistencial.");
            return;
        }

        int idVoluntario = Integer.parseInt(((String) cbxVoluntario.getSelectedItem()).split(" - ")[0]);
        int idHospital = Integer.parseInt(((String) cbxHospitalTarea.getSelectedItem()).split(" - ")[0]);

        Tarea t = new Tarea();
        t.setIdVoluntario(idVoluntario);
        t.setIdHospital(idHospital);
        t.setFecha(txtFecha.getText().trim());
        t.setHora(txtHora.getText().trim());
        t.setDescripcion(txtDescripcion.getText().trim());

        if (tareaDao.asignarTarea(t)) {
            voluntarioDao.actualizarEstado(idVoluntario, "Asignado");
            JOptionPane.showMessageDialog(vista, "Tarea asignada correctamente.");
        }
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
