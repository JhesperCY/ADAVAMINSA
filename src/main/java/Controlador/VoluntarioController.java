package Controlador;

import Dao.HospitalDao;
import Dao.VoluntarioDao;
import Modelo.Hospital;
import Modelo.Voluntario;
import Vista.FrmVoluntarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VoluntarioController implements ActionListener {
    
    private FrmVoluntarios vista;
    private VoluntarioDao dao;
    private HospitalDao hospitalDao;

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

        vista.getCbxHospital().removeAllItems();
        List<Hospital> hospitales = hospitalDao.listarTodos();
        if (hospitales.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "No se pudo cargar la lista de hospitales.\n"
                    + "Verifica que la tabla 'hospital' exista en tu base de datos.");
        }
        for (Hospital h : hospitales) {
            vista.getCbxHospital().addItem(h.getNombre());
        }
    }

    private void cargarTablaVoluntarios() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTblInfo().getModel();
        modelo.setRowCount(0);
        for (Voluntario v : dao.listarTodos()) {
            modelo.addRow(new Object[]{
                v.getDni(),
                v.getNombre() + " " + v.getApellido(),
                v.getEspecialidad(),
                v.getEstado(),
                v.getHorasServicio() + " hrs"
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            registrarVoluntario();
        } else if (e.getSource() == vista.getBtnActualizar()) {
            cargarTablaVoluntarios();
        } else if (e.getSource() == vista.getBtnSalir()) {
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Funcionalidad en desarrollo.");
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

    private void limpiarCampos() {
        vista.getTxtDni().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtCelular().setText("");
        vista.getTxtCorreo().setText("");
    }
    
}
