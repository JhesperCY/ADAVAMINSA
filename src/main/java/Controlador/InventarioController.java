package Controlador;

import Dao.MedicinaDao;
import Modelo.Medicina;
import Vista.FrmInventario;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InventarioController implements ActionListener {
    
    private final FrmInventario vista;
    private final MedicinaDao dao;

    public InventarioController(FrmInventario vista) {
        this.vista = vista;
        this.dao = new MedicinaDao();

        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnEditar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnSalir().addActionListener(this);
        vista.getCbxCategoria().addActionListener(this);
        vista.getCbxEstado().addActionListener(this);
        vista.getTxtBuscar().addActionListener(this);

        cargarCombos();
        cargarTabla(dao.listarMedicinas());
    }

    private void cargarCombos() {
        // Estos combos no tenían NINGÚN dato antes (por eso salían vacíos
        // o con los "Item 1/2/3" de NetBeans): nadie los llenaba.
        vista.getCbxCategoria().removeAllItems();
        for (String c : new String[]{"Todas", "Analgésico", "Antibiótico", "Material Quirúrgico", "Otro"}) {
            vista.getCbxCategoria().addItem(c);
        }
        vista.getCbxEstado().removeAllItems();
        for (String e : new String[]{"Todos", "Vigente", "Por vencer", "Vencido"}) {
            vista.getCbxEstado().addItem(e);
        }
    }

    private DefaultTableModel modeloVacio() {
        return new DefaultTableModel(
                new Object[]{"ID", "Medicamento", "Categoria", "Stock", "Lote", "Caduca", "Estado"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private void cargarTabla(List<Medicina> lista) {
        DefaultTableModel modelo = modeloVacio();
        for (Medicina m : lista) {
            modelo.addRow(new Object[]{
                m.getIdMedicina(), m.getNombre(), m.getCategoria(), m.getCantidad(),
                m.getLote(), m.getFechaVencimiento(), calcularEstado(m.getFechaVencimiento())
            });
        }
        vista.getTblInfo().setModel(modelo);
        ocultarColumnaId();
    }

    private void ocultarColumnaId() {
        vista.getTblInfo().getColumnModel().getColumn(0).setMinWidth(0);
        vista.getTblInfo().getColumnModel().getColumn(0).setMaxWidth(0);
        vista.getTblInfo().getColumnModel().getColumn(0).setWidth(0);
    }

    private String calcularEstado(String fechaVencimiento) {
        if (fechaVencimiento == null || fechaVencimiento.isBlank()) {
            return "Sin dato";
        }
        try {
            LocalDate caduca = LocalDate.parse(fechaVencimiento.substring(0, 10));
            LocalDate hoy = LocalDate.now();
            if (caduca.isBefore(hoy)) {
                return "Vencido";
            }
            if (caduca.isBefore(hoy.plusMonths(3))) {
                return "Por vencer";
            }
            return "Vigente";
        } catch (Exception ex) {
            return "Sin dato";
        }
    }

    private void filtrarYBuscar() {
        String categoria = (String) vista.getCbxCategoria().getSelectedItem();
        String estado = (String) vista.getCbxEstado().getSelectedItem();
        String texto = vista.getTxtBuscar().getText().trim().toLowerCase();

        DefaultTableModel modelo = modeloVacio();
        for (Medicina m : dao.listarMedicinas()) {
            String estadoCalc = calcularEstado(m.getFechaVencimiento());
            boolean coincideTexto = texto.isEmpty() || (m.getNombre() != null && m.getNombre().toLowerCase().contains(texto));
            boolean coincideCategoria = categoria == null || categoria.equals("Todas") || categoria.equals(m.getCategoria());
            boolean coincideEstado = estado == null || estado.equals("Todos") || estado.equals(estadoCalc);
            if (coincideTexto && coincideCategoria && coincideEstado) {
                modelo.addRow(new Object[]{
                    m.getIdMedicina(), m.getNombre(), m.getCategoria(), m.getCantidad(),
                    m.getLote(), m.getFechaVencimiento(), estadoCalc
                });
            }
        }
        vista.getTblInfo().setModel(modelo);
        ocultarColumnaId();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();
        if (origen == vista.getBtnAgregar()) {
            agregar();
        } else if (origen == vista.getBtnEditar()) {
            editar();
        } else if (origen == vista.getBtnEliminar()) {
            eliminar();
        } else if (origen == vista.getBtnActualizar()) {
            cargarTabla(dao.listarMedicinas());
        } else if (origen == vista.getBtnSalir()) {
            vista.dispose();
        } else if (origen == vista.getCbxCategoria() || origen == vista.getCbxEstado() || origen == vista.getTxtBuscar()) {
            filtrarYBuscar();
        }
    }

    private JPanel construirFormulario(JTextField nombre, JTextField categoria, JTextField lote,
            JTextField cantidad, JTextField fecha) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nombre del medicamento:"));
        panel.add(nombre);
        panel.add(new JLabel("Categoria:"));
        panel.add(categoria);
        panel.add(new JLabel("Lote:"));
        panel.add(lote);
        panel.add(new JLabel("Cantidad:"));
        panel.add(cantidad);
        panel.add(new JLabel("Fecha de vencimiento (AAAA-MM-DD):"));
        panel.add(fecha);
        return panel;
    }

    private void agregar() {
        JTextField txtNombre = new JTextField();
        JTextField txtCategoria = new JTextField();
        JTextField txtLote = new JTextField();
        JTextField txtCantidad = new JTextField();
        JTextField txtFecha = new JTextField();

        JPanel panel = construirFormulario(txtNombre, txtCategoria, txtLote, txtCantidad, txtFecha);
        int opcion = JOptionPane.showConfirmDialog(vista, panel,
                "Registrar nuevo ingreso de medicina", JOptionPane.OK_CANCEL_OPTION);
        if (opcion != JOptionPane.OK_OPTION) {
            return;
        }
        if (txtNombre.getText().isBlank() || txtCantidad.getText().isBlank()) {
            JOptionPane.showMessageDialog(vista, "Nombre y cantidad son obligatorios.");
            return;
        }
        try {
            Medicina m = new Medicina();
            m.setNombre(txtNombre.getText().trim());
            m.setCategoria(txtCategoria.getText().trim());
            m.setLote(txtLote.getText().trim());
            m.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
            m.setFechaVencimiento(txtFecha.getText().trim());
            if (dao.registrar(m)) {
                JOptionPane.showMessageDialog(vista, "Medicina registrada correctamente.");
                cargarTabla(dao.listarMedicinas());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número entero.");
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

    private void editar() {
        int id = obtenerIdSeleccionado();
        if (id == -1) {
            return;
        }
        int fila = vista.getTblInfo().getSelectedRow();
        JTextField txtNombre = new JTextField(String.valueOf(vista.getTblInfo().getModel().getValueAt(fila, 1)));
        JTextField txtCategoria = new JTextField(String.valueOf(vista.getTblInfo().getModel().getValueAt(fila, 2)));
        JTextField txtCantidad = new JTextField(String.valueOf(vista.getTblInfo().getModel().getValueAt(fila, 3)));
        JTextField txtLote = new JTextField(String.valueOf(vista.getTblInfo().getModel().getValueAt(fila, 4)));
        JTextField txtFecha = new JTextField(String.valueOf(vista.getTblInfo().getModel().getValueAt(fila, 5)));

        JPanel panel = construirFormulario(txtNombre, txtCategoria, txtLote, txtCantidad, txtFecha);
        int opcion = JOptionPane.showConfirmDialog(vista, panel, "Editar medicina", JOptionPane.OK_CANCEL_OPTION);
        if (opcion != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            Medicina m = new Medicina();
            m.setIdMedicina(id);
            m.setNombre(txtNombre.getText().trim());
            m.setCategoria(txtCategoria.getText().trim());
            m.setLote(txtLote.getText().trim());
            m.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
            m.setFechaVencimiento(txtFecha.getText().trim());
            if (dao.actualizar(m)) {
                JOptionPane.showMessageDialog(vista, "Medicina actualizada.");
                cargarTabla(dao.listarMedicinas());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número entero.");
        }
    }

    private void eliminar() {
        int id = obtenerIdSeleccionado();
        if (id == -1) {
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(vista,
                "¿Está seguro de eliminar este medicamento del inventario?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION && dao.eliminar(id)) {
            JOptionPane.showMessageDialog(vista, "Medicina eliminada.");
            cargarTabla(dao.listarMedicinas());
        }
    } 
}
