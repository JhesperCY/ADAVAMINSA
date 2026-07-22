package Controlador;

import Dao.DonanteDao;
import Dao.DonativoDao;
import Dao.MedicinaDao;
import Modelo.Donante;
import Modelo.Donativo;
import Modelo.Medicina;
import Vista.FrmDonaciones;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DonacionController implements ActionListener{
    
    private final FrmDonaciones vista;
    private final DonativoDao daoDonativo;
    private final MedicinaDao daoMedicina;
    private final DonanteDao daoDonante;

    public DonacionController(FrmDonaciones vista) {
        this.vista = vista;
        this.daoDonativo = new DonativoDao();
        this.daoMedicina = new MedicinaDao();
        this.daoDonante = new DonanteDao();

        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnEditar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnSalir().addActionListener(this);

        cargarCombos();
        cargarTablaHistorial();
    }

    private void cargarCombos() {
        vista.getCbxDonante().removeAllItems();
        for (Donante d : daoDonante.listarTodos()) {
            vista.getCbxDonante().addItem(d.getNombre() + " (ID:" + d.getIdDonante() + ")");
        }
        vista.getCbxMedicina().removeAllItems();
        for (Medicina m : daoMedicina.listarMedicinas()) {
            vista.getCbxMedicina().addItem(m.getNombre() + " (ID:" + m.getIdMedicina() + ")");
        }
    }

    /**
     * Antes esta tabla mostraba las columnas reales de la ventana
     * ("Donante","Hospital","Medicamento","Cantidad","Fecha") pero el código
     * metía los valores en OTRO orden (cantidad en la columna Fecha, fecha en
     * la columna Cantidad, etc). Aquí se reconstruye la tabla con encabezados
     * que sí corresponden a los datos reales que tenemos disponibles (no existe
     * una columna "hospital" en la base de datos: ese dato se guarda dentro de
     * "Observaciones").
     */
    private void cargarTablaHistorial() {
        Map<Integer, String> nombresDonante = new HashMap<>();
        for (Donante d : daoDonante.listarTodos()) {
            nombresDonante.put(d.getIdDonante(), d.getNombre());
        }
        Map<Integer, String> nombresMedicina = new HashMap<>();
        for (Medicina m : daoMedicina.listarMedicinas()) {
            nombresMedicina.put(m.getIdMedicina(), m.getNombre());
        }

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID", "Donante", "Medicamento", "Cantidad", "Fecha", "Observaciones"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Donativo d : daoDonativo.listarHistorial()) {
            String donante = nombresDonante.getOrDefault(d.getIdDonante(), "ID " + d.getIdDonante());
            String medicina = nombresMedicina.getOrDefault(d.getIdMedicina(), "ID " + d.getIdMedicina());
            modelo.addRow(new Object[]{
                d.getIdDonativo(), donante, medicina, d.getCantidad(), d.getFecha(), d.getObservaciones()
            });
        }
        vista.getTblInfo().setModel(modelo);
        vista.getTblInfo().getColumnModel().getColumn(0).setMinWidth(0);
        vista.getTblInfo().getColumnModel().getColumn(0).setMaxWidth(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            registrarDonacion();
        } else if (e.getSource() == vista.getBtnEditar()) {
            editarDonacion();
        } else if (e.getSource() == vista.getBtnEliminar()) {
            eliminarDonacion();
        } else if (e.getSource() == vista.getBtnActualizar()) {
            cargarTablaHistorial();
            cargarCombos();
        } else if (e.getSource() == vista.getBtnSalir()) {
            vista.dispose();
        }
    }

    private int extraerId(String textoCombo) {
        return Integer.parseInt(textoCombo.substring(textoCombo.indexOf("ID:") + 3, textoCombo.indexOf(")")));
    }

    private void registrarDonacion() {
        try {
            int idxDonante = vista.getCbxDonante().getSelectedIndex();
            int idxMedicina = vista.getCbxMedicina().getSelectedIndex();
            if (idxDonante < 0 || idxMedicina < 0) {
                JOptionPane.showMessageDialog(vista, "Seleccione donante y medicina.");
                return;
            }
            int idDonante = extraerId(vista.getCbxDonante().getSelectedItem().toString());
            int idMedicina = extraerId(vista.getCbxMedicina().getSelectedItem().toString());

            int cantidad = Integer.parseInt(vista.getTxtCantidad().getText().trim());
            if (vista.getDtcFecha().getDate() == null) {
                JOptionPane.showMessageDialog(vista, "Seleccione la fecha de ingreso.");
                return;
            }
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(vista.getDtcFecha().getDate());
            String hospital = vista.getTxtHospital().getText().trim();
            String observacionesTexto = vista.getTxtObservaciones().getText().trim();
            String observacionesFinal = hospital.isEmpty()
                    ? observacionesTexto
                    : "Hospital destino: " + hospital + (observacionesTexto.isEmpty() ? "" : " - " + observacionesTexto);

            Donativo d = new Donativo();
            d.setIdDonante(idDonante);
            d.setIdMedicina(idMedicina);
            d.setCantidad(cantidad);
            d.setFecha(fecha);
            d.setObservaciones(observacionesFinal);

            if (daoDonativo.registrarDonativo(d)) {
                daoMedicina.actualizarStock(idMedicina, cantidad);
                JOptionPane.showMessageDialog(vista, "Donación registrada correctamente.");
                cargarTablaHistorial();
                limpiarCampos();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Cantidad debe ser numérica.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error: " + ex.getMessage());
        }
    }

    private int obtenerIdSeleccionado() {
        int fila = vista.getTblInfo().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un registro de la tabla.");
            return -1;
        }
        return (int) vista.getTblInfo().getModel().getValueAt(fila, 0);
    }

    private void editarDonacion() {
        int id = obtenerIdSeleccionado();
        if (id == -1) {
            return;
        }
        int fila = vista.getTblInfo().getSelectedRow();
        List<Donativo> historial = daoDonativo.listarHistorial();
        Donativo actual = historial.stream().filter(d -> d.getIdDonativo() == id).findFirst().orElse(null);
        if (actual == null) {
            return;
        }

        JTextField txtCantidad = new JTextField(String.valueOf(actual.getCantidad()));
        JTextField txtFecha = new JTextField(actual.getFecha());
        JTextField txtObservaciones = new JTextField(actual.getObservaciones());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Cantidad:"));
        panel.add(txtCantidad);
        panel.add(new JLabel("Fecha (AAAA-MM-DD):"));
        panel.add(txtFecha);
        panel.add(new JLabel("Observaciones:"));
        panel.add(txtObservaciones);

        int opcion = JOptionPane.showConfirmDialog(vista, panel, "Editar donación", JOptionPane.OK_CANCEL_OPTION);
        if (opcion != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            actual.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
            actual.setFecha(txtFecha.getText().trim());
            actual.setObservaciones(txtObservaciones.getText().trim());
            if (daoDonativo.actualizar(actual)) {
                JOptionPane.showMessageDialog(vista, "Donación actualizada.");
                cargarTablaHistorial();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número entero.");
        }
    }

    private void eliminarDonacion() {
        int id = obtenerIdSeleccionado();
        if (id == -1) {
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(vista,
                "¿Eliminar este registro de donación del historial?\n"
                + "(No descuenta el stock ya sumado al inventario.)",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION && daoDonativo.eliminar(id)) {
            cargarTablaHistorial();
        }
    }

    private void limpiarCampos() {
        vista.getTxtCantidad().setText("");
        vista.getTxtObservaciones().setText("");
        vista.getTxtHospital().setText("");
        vista.getDtcFecha().setDate(null);
    }
    
}
