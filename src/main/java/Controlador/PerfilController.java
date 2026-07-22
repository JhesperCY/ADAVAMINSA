package Controlador;

import Dao.UsuarioDao;
import Modelo.Usuario;
import Vista.FrmPerfil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PerfilController implements ActionListener {
    
    private final FrmPerfil vista;
    private final UsuarioDao dao;
    private final Usuario usuario;

    public PerfilController(FrmPerfil vista) {
        this.vista = vista;
        this.dao = new UsuarioDao();
        this.usuario = vista.getUsuario();

        vista.getBtnGuardar().addActionListener(this);
        vista.getBtnCancelar().addActionListener(this);
        vista.getBtnGuardarE().addActionListener(this);
        vista.getBtnCancelarE().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnGuardar()) {
            guardarPerfil();
        } else if (e.getSource() == vista.getBtnCancelar()) {
            vista.getTxtNombre().setText(usuario.getNombre());
        } else if (e.getSource() == vista.getBtnGuardarE()) {
            cambiarPassword();
        } else if (e.getSource() == vista.getBtnCancelarE()) {
            limpiarPasswords();
        }
    }

    private void guardarPerfil() {
        if (usuario == null) {
            return;
        }
        String nombre = vista.getTxtNombre().getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El nombre no puede estar vacío.");
            return;
        }
        usuario.setNombre(nombre);
        if (dao.actualizarPerfil(usuario)) {
            JOptionPane.showMessageDialog(vista, "Perfil actualizado correctamente.");
        }
    }

    private void cambiarPassword() {
        if (usuario == null) {
            return;
        }
        String actual = new String(vista.getPwdContraseña().getPassword());
        String nueva = new String(vista.getPwdNuevacontraseña().getPassword());
        String confirmar = new String(vista.getPwdConfirmarcontraseña().getPassword());

        if (actual.isEmpty() || nueva.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Complete los tres campos de contraseña.");
            return;
        }
        if (!nueva.equals(confirmar)) {
            JOptionPane.showMessageDialog(vista, "La nueva contraseña y su confirmación no coinciden.");
            return;
        }

        if (dao.cambiarPassword(usuario.getIdUsuario(), actual, nueva)) {
            JOptionPane.showMessageDialog(vista, "Contraseña actualizada correctamente.");
            limpiarPasswords();
        }
    }

    private void limpiarPasswords() {
        vista.getPwdContraseña().setText("");
        vista.getPwdNuevacontraseña().setText("");
        vista.getPwdConfirmarcontraseña().setText("");
    }
    
}
