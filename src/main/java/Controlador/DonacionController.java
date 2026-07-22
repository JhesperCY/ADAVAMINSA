package Controlador;

import Dao.DonativoDao;
import Dao.MedicinaDao;
import Dao.DonanteDao;
import Modelo.Donativo;
import Modelo.Medicina;
import Modelo.Donante;
import Vista.FrmDonaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DonacionController implements ActionListener{
    
    private FrmDonaciones vista;
    private DonativoDao daoDonativo;
    private MedicinaDao daoMedicina;
    private DonanteDao daoDonante;

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

    private void cargarTablaHistorial() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTblInfo().getModel();
        modelo.setRowCount(0);
        for (Donativo d : daoDonativo.listarHistorial()) {
            String donante = "ID " + d.getIdDonante();
            String medicina = "ID " + d.getIdMedicina();
            modelo.addRow(new Object[]{
                donante,
                medicina,
                d.getCantidad(),
                d.getFecha(),
                d.getObservaciones()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            registrarDonacion();
        } else if (e.getSource() == vista.getBtnActualizar()) {
            cargarTablaHistorial();
            cargarCombos();
        } else if (e.getSource() == vista.getBtnSalir()) {
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Funcionalidad en desarrollo.");
        }
    }

    private void registrarDonacion() {
        try {
            int idxDonante = vista.getCbxDonante().getSelectedIndex();
            int idxMedicina = vista.getCbxMedicina().getSelectedIndex();
            if (idxDonante < 0 || idxMedicina < 0) {
                JOptionPane.showMessageDialog(vista, "Seleccione donante y medicina.");
                return;
            }
            String donanteText = vista.getCbxDonante().getSelectedItem().toString();
            int idDonante = Integer.parseInt(donanteText.substring(donanteText.indexOf("ID:") + 3, donanteText.indexOf(")")));
            String medicinaText = vista.getCbxMedicina().getSelectedItem().toString();
            int idMedicina = Integer.parseInt(medicinaText.substring(medicinaText.indexOf("ID:") + 3, medicinaText.indexOf(")")));

            int cantidad = Integer.parseInt(vista.getTxtCantidad().getText().trim());
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(vista.getDtcFecha().getDate());
            String observaciones = vista.getTxtObservaciones().getText().trim();

            Donativo d = new Donativo();
            d.setIdDonante(idDonante);
            d.setIdMedicina(idMedicina);
            d.setCantidad(cantidad);
            d.setFecha(fecha);
            d.setObservaciones(observaciones);

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

    private void limpiarCampos() {
        vista.getTxtCantidad().setText("");
        vista.getTxtObservaciones().setText("");
        vista.getDtcFecha().setDate(null);
    }
    
}
