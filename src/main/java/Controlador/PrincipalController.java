package Controlador;

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
import javax.swing.JInternalFrame;

public class PrincipalController implements ActionListener{
    
    private FrmPrincipal vista;
    private Usuario usuario;

    public PrincipalController(FrmPrincipal vista, Usuario usuario) {

        this.vista = vista;
        this.usuario = usuario;
        

        //Botones
        vista.getBtnInicio().addActionListener(this);
        vista.getBtnInventario().addActionListener(this);
        vista.getBtnDonaciones().addActionListener(this);
        vista.getBtnVoluntarios().addActionListener(this);
        vista.getBtnReportes().addActionListener(this);
        vista.getBtnPerfil().addActionListener(this);

        //Menú Archivo
        vista.getItemCerrarSesion().addActionListener(this);
        vista.getItemSalir().addActionListener(this);

        //Inventario
        vista.getItemRegistrarMedicamento().addActionListener(this);
        vista.getItemRegistrarLote().addActionListener(this);
        vista.getItemBuscarMedicamento().addActionListener(this);

        //Donaciones
        vista.getItemNuevaDonacion().addActionListener(this);
        vista.getItemHistorial().addActionListener(this);

        //Voluntarios
        vista.getItemRegistrarNuevoVoluntario().addActionListener(this);
        vista.getItemBuscarVoluntario().addActionListener(this);
        vista.getItemAsignarTarea().addActionListener(this);

        //Reportes
        vista.getItemStock().addActionListener(this);
        vista.getItemMedicamentosProximosaVencer().addActionListener(this);
        vista.getItemDonaciones().addActionListener(this);
        vista.getItemVoluntarios().addActionListener(this);

        //Ayuda
        vista.getItemManual().addActionListener(this);
        vista.getItemAcercaDe().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object origen = e.getSource();

        if (origen == vista.getBtnInicio()) {
            abrirInicio();
        }

        if (origen == vista.getBtnInventario()) {
            abrirInventario();
        }

        if (origen == vista.getBtnDonaciones()) {
            abrirDonaciones();
        }

        if (origen == vista.getBtnVoluntarios()) {
            abrirVoluntarios();
        }

        if (origen == vista.getBtnReportes()) {
            abrirReportes();
        }

//        if (origen == vista.getBtnPerfil()) {
//            abrirPerfil();
//        }

        if (origen == vista.getItemCerrarSesion()) {
            cerrarSesion();
        }

        if (origen == vista.getItemSalir()) {
            System.exit(0);
        }
    }
    
    private void abrirInicio() {
        vista.getDesktopPrincipal().removeAll();
        vista.getDesktopPrincipal().repaint();
    }

    private void abrirInventario() {
        vista.getDesktopPrincipal().removeAll();
        vista.getDesktopPrincipal().repaint();
        FrmInventario frm = new FrmInventario();
        vista.getDesktopPrincipal().add(frm);
        new InventarioController(frm);
        frm.setVisible(true);
    }

    private void abrirDonaciones() {
        vista.getDesktopPrincipal().removeAll();
        vista.getDesktopPrincipal().repaint();
        FrmDonaciones frm = new FrmDonaciones();
        vista.getDesktopPrincipal().add(frm);
        frm.setVisible(true);
    }

    private void abrirVoluntarios() {
        vista.getDesktopPrincipal().removeAll();
        vista.getDesktopPrincipal().repaint();
        FrmVoluntarios frm = new FrmVoluntarios();
        vista.getDesktopPrincipal().add(frm);
        frm.setVisible(true);
    }

    private void abrirReportes() {
        vista.getDesktopPrincipal().removeAll();
        vista.getDesktopPrincipal().repaint();
        FrmReportes frm = new FrmReportes();
        vista.getDesktopPrincipal().add(frm);
        frm.setVisible(true);
    }

//    private void abrirPerfil() {
//        vista.getDesktopPrincipal().removeAll();
//        vista.getDesktopPrincipal().repaint();
//        FrmPerfil frm = new FrmPerfil(usuario);
//        vista.getDesktopPrincipal().add(frm);
//        frm.setVisible(true);
//    }

    private void cerrarSesion() {
        vista.dispose();
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        new LoginController(login);
    }
}
