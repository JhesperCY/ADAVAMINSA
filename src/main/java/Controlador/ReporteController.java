package Controlador;

import Dao.DonativoDao;
import Dao.MedicinaDao;
import Dao.VoluntarioDao;
import Modelo.Donativo;
import Modelo.Medicina;
import Modelo.Voluntario;
import Vista.FrmReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReporteController implements ActionListener {
    
    private final FrmReportes vista;
    private final MedicinaDao medicinaDao;
    private final DonativoDao donativoDao;
    private final VoluntarioDao voluntarioDao;

    public ReporteController(FrmReportes vista) {
        this.vista = vista;
        this.medicinaDao = new MedicinaDao();
        this.donativoDao = new DonativoDao();
        this.voluntarioDao = new VoluntarioDao();

        vista.getBtnImprimirRI().addActionListener(this);
        vista.getBtnImprimirRD().addActionListener(this);
        vista.getBtnImprimirRV().addActionListener(this);
        vista.getBtnSalirRI().addActionListener(this);
        vista.getBtnSalirRD().addActionListener(this);
        vista.getBtnSalirRV().addActionListener(this);

        cargarReporteInventario();
        cargarReporteDonaciones();
        cargarReporteVoluntarios();
    }

    private void cargarReporteInventario() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Medicamento", "Categoria", "Stock", "Lote", "Vencimiento"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Medicina m : medicinaDao.listarMedicinas()) {
            modelo.addRow(new Object[]{m.getNombre(), m.getCategoria(), m.getCantidad(), m.getLote(), m.getFechaVencimiento()});
        }
        vista.getTblInfoRI().setModel(modelo);
    }

    private void cargarReporteDonaciones() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID Donante", "ID Medicina", "Cantidad", "Fecha", "Observaciones"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Donativo d : donativoDao.listarHistorial()) {
            modelo.addRow(new Object[]{d.getIdDonante(), d.getIdMedicina(), d.getCantidad(), d.getFecha(), d.getObservaciones()});
        }
        vista.getTblInfoRD().setModel(modelo);
    }

    private void cargarReporteVoluntarios() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"DNI", "Nombre", "Especialidad", "Estado", "Horas"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Voluntario v : voluntarioDao.listarTodos()) {
            modelo.addRow(new Object[]{v.getDni(), v.getNombre() + " " + v.getApellido(),
                v.getEspecialidad(), v.getEstado(), v.getHorasServicio()});
        }
        vista.getTblInfoRV().setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnImprimirRI()) {
            imprimir(vista.getTblInfoRI(), "Reporte de Inventario");
        } else if (e.getSource() == vista.getBtnImprimirRD()) {
            imprimir(vista.getTblInfoRD(), "Reporte de Donaciones");
        } else if (e.getSource() == vista.getBtnImprimirRV()) {
            imprimir(vista.getTblInfoRV(), "Reporte de Voluntariado");
        } else if (e.getSource() == vista.getBtnSalirRI()
                || e.getSource() == vista.getBtnSalirRD()
                || e.getSource() == vista.getBtnSalirRV()) {
            vista.dispose();
        }
    }

    private void imprimir(JTable tabla, String titulo) {
        try {
            boolean seImprimio = tabla.print(JTable.PrintMode.FIT_WIDTH,
                    new java.text.MessageFormat(titulo), new java.text.MessageFormat("Página {0}"));
            if (!seImprimio) {
                JOptionPane.showMessageDialog(vista, "Impresión cancelada.");
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(vista, "Error al imprimir: " + ex.getMessage());
        }
    }
    
}
