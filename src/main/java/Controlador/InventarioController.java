package Controlador;

import Vista.FrmInventario;
import Modelo.Medicina;
import Dao.MedicinaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class InventarioController implements ActionListener {
    
    private FrmInventario vista;
    private MedicinaDao dao;

    public InventarioController(FrmInventario vista) {

        this.vista = vista;
        this.dao = new MedicinaDao();

        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnEditar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnSalir().addActionListener(this);

        cargarTabla();
    }

    private void cargarTabla() {

        DefaultTableModel modelo
                = (DefaultTableModel) vista.getTblInfo().getModel();

        modelo.setRowCount(0);

        for (Medicina m : dao.listarMedicinas()) {

            modelo.addRow(new Object[]{
                m.getNombre(),
                m.getCategoria(),
                m.getCantidad(),
                m.getLote(),
                m.getFechaVencimiento(),
                "Disponible"
            });

        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnActualizar()) {
            cargarTabla();
        }
        if (e.getSource() == vista.getBtnSalir()) {

            vista.dispose();
        }
    } 
}
