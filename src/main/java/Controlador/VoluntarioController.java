package Controlador;

import Dao.HospitalDao;
import Dao.VoluntarioDao;
import Modelo.Hospital;
import Modelo.Voluntario;
import Vista.FrmVoluntarios;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VoluntarioController implements ActionListener {
    
    private final FrmVoluntarios vista;
    private final VoluntarioDao dao;
    private final HospitalDao hospitalDao;

    public VoluntarioController(FrmVoluntarios vista) {
        this.vista = vista;
        this.dao = new VoluntarioDao();
        this.hospitalDao = new HospitalDao();

        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnEditar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnSalir().addActionListener(this);

        cargarCombos();
        cargarTablaVoluntarios();
    }

    private void cargarCombos() {
        String[] especialidades = {"Médico", "Enfermería", "Psicología", "Trabajo Social", "Nutrición", "Otros"};
        vista.getCbxEspecialidad().removeAllItems();
        for (String esp : especialidades) {
            vista.getCbxEspecialidad().addItem(esp);
        }
        String[] estados = {"Activo", "Inactivo", "Asignado"};
        vista.getCbxEstado().removeAllItems();
        for (String est : estados) {
            vista.getCbxEstado().addItem(est);
        }

        // Combo que se quedaba con los "Item 1/2/3" de NetBeans (informativo,
        // no se guarda en la tabla voluntario todavía).
        vista.getCbxHospital().removeAllItems();
        List<Hospital> hospitales = hospitalDao.listarTodos();
        for (Hospital h : hospitales) {
            vista.getCbxHospital().addItem(h.getNombre());
        }
    }

    /**
     * Antes esta tabla se quedaba con los encabezados de diseño ("Title 1",
     * "Title 2"...) porque el código solo vaciaba filas del modelo original en
     * vez de crear uno con encabezados reales.
     */
    private void cargarTablaVoluntarios() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID", "DNI", "Nombre", "Especialidad", "Estado", "Horas"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Voluntario v : dao.listarTodos()) {
            modelo.addRow(new Object[]{
                v.getIdVoluntario(), v.getDni(), v.getNombre() + " " + v.getApellido(),
                v.getEspecialidad(), v.getEstado(), v.getHorasServicio()
            });
        }
        vista.getTblInfo().setModel(modelo);
        vista.getTblInfo().getColumnModel().getColumn(0).setMinWidth(0);
        vista.getTblInfo().getColumnModel().getColumn(0).setMaxWidth(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            registrarVoluntario();
        } else if (e.getSource() == vista.getBtnEditar()) {
            editarVoluntario();
        } else if (e.getSource() == vista.getBtnEliminar()) {
            eliminarVoluntario();
        } else if (e.getSource() == vista.getBtnActualizar()) {
            cargarTablaVoluntarios();
        } else if (e.getSource() == vista.getBtnSalir()) {
            vista.dispose();
        }
    }

    private void registrarVoluntario() {
        try {
            Voluntario v = new Voluntario();
            v.setDni(vista.getTxtDni().getText().trim());
            v.setNombre(vista.getTxtNombre().getText().trim());
            v.setApellido(vista.getTxtApellido().getText().trim());
            v.setTelefono(vista.getTxtCelular().getText().trim());
            v.setEspecialidad(vista.getCbxEspecialidad().getSelectedItem().toString());
            v.setDisponibilidad("Lunes a Viernes");
            v.setEstado(vista.getCbxEstado().getSelectedItem().toString());

            if (v.getDni().isEmpty() || v.getNombre().isEmpty() || v.getApellido().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Complete los campos obligatorios.");
                return;
            }

            if (dao.registrar(v)) {
                JOptionPane.showMessageDialog(vista, "Voluntario registrado.");
                cargarTablaVoluntarios();
                limpiarCampos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error: " + ex.getMessage());
        }
    }

    private int obtenerIdSeleccionado() {
        int fila = vista.getTblInfo().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un voluntario de la tabla.");
            return -1;
        }
        return (int) vista.getTblInfo().getModel().getValueAt(fila, 0);
    }

    private void editarVoluntario() {
        int id = obtenerIdSeleccionado();
        if (id == -1) {
            return;
        }
        Voluntario actual = dao.listarTodos().stream()
                .filter(v -> v.getIdVoluntario() == id).findFirst().orElse(null);
        if (actual == null) {
            return;
        }

        JTextField txtDni = new JTextField(actual.getDni());
        JTextField txtNombre = new JTextField(actual.getNombre());
        JTextField txtApellido = new JTextField(actual.getApellido());
        JTextField txtCelular = new JTextField(actual.getTelefono());
        JComboBox<String> cbxEspecialidadEdit = new JComboBox<>(
                new String[]{"Médico", "Enfermería", "Psicología", "Trabajo Social", "Nutrición", "Otros"});
        cbxEspecialidadEdit.setSelectedItem(actual.getEspecialidad());
        JComboBox<String> cbxEstadoEdit = new JComboBox<>(new String[]{"Activo", "Inactivo", "Asignado"});
        cbxEstadoEdit.setSelectedItem(actual.getEstado());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("DNI:"));
        panel.add(txtDni);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Apellido:"));
        panel.add(txtApellido);
        panel.add(new JLabel("Celular:"));
        panel.add(txtCelular);
        panel.add(new JLabel("Especialidad:"));
        panel.add(cbxEspecialidadEdit);
        panel.add(new JLabel("Estado:"));
        panel.add(cbxEstadoEdit);

        int opcion = JOptionPane.showConfirmDialog(vista, panel, "Editar voluntario", JOptionPane.OK_CANCEL_OPTION);
        if (opcion != JOptionPane.OK_OPTION) {
            return;
        }
        actual.setDni(txtDni.getText().trim());
        actual.setNombre(txtNombre.getText().trim());
        actual.setApellido(txtApellido.getText().trim());
        actual.setTelefono(txtCelular.getText().trim());
        actual.setEspecialidad((String) cbxEspecialidadEdit.getSelectedItem());
        actual.setEstado((String) cbxEstadoEdit.getSelectedItem());

        if (dao.actualizar(actual)) {
            JOptionPane.showMessageDialog(vista, "Voluntario actualizado.");
            cargarTablaVoluntarios();
        }
    }

    private void eliminarVoluntario() {
        int id = obtenerIdSeleccionado();
        if (id == -1) {
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(vista,
                "¿Está seguro de eliminar a este voluntario?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION && dao.eliminar(id)) {
            JOptionPane.showMessageDialog(vista, "Voluntario eliminado.");
            cargarTablaVoluntarios();
        }
    }

    private void limpiarCampos() {
        vista.getTxtDni().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtCelular().setText("");
        vista.getTxtCorreo().setText("");
    }
    
}
