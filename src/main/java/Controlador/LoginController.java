package Controlador;

import Dao.UsuarioDao;
import Modelo.Usuario;
import Vista.FrmLogin;
import Vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController implements ActionListener{
    private FrmLogin vista;
    private UsuarioDao dao;

    public LoginController(FrmLogin vista) {

        this.vista = vista;
        this.dao = new UsuarioDao();

        vista.btnIngresar.addActionListener(this);
        vista.btnSalir.addActionListener(this);
        vista.txtUsuario.addActionListener(this);
        vista.txtContraseña.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object origen = e.getSource();

        if (origen == vista.btnSalir) {
            salir();
        }

        if (origen == vista.btnIngresar || origen == vista.txtContraseña) {
            login();
        }

        if (origen == vista.txtUsuario) {
            vista.txtContraseña.requestFocus();
        }
    }

    private void salir() {

        int opcion = JOptionPane.showConfirmDialog(
                vista,
                "¿Está seguro que desea salir de ADAVAMINSA?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

    private void login() {

        String usuario = vista.txtUsuario.getText().trim();
        String password = String.valueOf(vista.txtContraseña.getPassword());

        if (usuario.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(vista,
                    "Complete todos los campos.");

            return;
        }

        Usuario usuarioLogueado = dao.login(usuario, password);

        if (usuarioLogueado == null) {

            JOptionPane.showMessageDialog(vista,
                    "Usuario o contraseña incorrectos.");

            vista.txtContraseña.setText("");
            vista.txtUsuario.requestFocus();

            return;
        }

        String rolVista = vista.cbxRol.getSelectedItem().toString();

        if (!usuarioLogueado.getRol().equalsIgnoreCase(rolVista)) {

            JOptionPane.showMessageDialog(vista,
                    "El rol seleccionado no coincide.");

            return;
        }

//        JOptionPane.showMessageDialog(vista,
//                "Bienvenido " + usuarioLogueado.getNombre());
//
//        FrmPrincipal frm = new FrmPrincipal(usuarioLogueado);
//        frm.setVisible(true);
//
//        vista.dispose();
    }
}
