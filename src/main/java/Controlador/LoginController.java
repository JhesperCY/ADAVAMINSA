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

        // Validación 1: Campos vacíos
        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "Complete todos los campos.",
                    "Campos Incompletos",
                    JOptionPane.WARNING_MESSAGE);
            vista.txtUsuario.requestFocus();
            return;
        }

        // Validación 2: Consultar usuario en BD
        Usuario usuarioLogueado = dao.login(usuario, password);

        if (usuarioLogueado == null) {
            JOptionPane.showMessageDialog(vista,
                    "Usuario o contraseña incorrectos.",
                    "Acceso Denegado",
                    JOptionPane.ERROR_MESSAGE);
            vista.txtContraseña.setText("");
            vista.txtUsuario.requestFocus();
            return;
        }

        // Validación 3: Verificar que el rol coincida
        String rolVista = vista.cbxRol.getSelectedItem().toString();

        if (!usuarioLogueado.getRol().equalsIgnoreCase(rolVista)) {
            JOptionPane.showMessageDialog(vista,
                    "El rol seleccionado no coincide con el del usuario.\n\n"
                    + "Rol en el sistema: " + usuarioLogueado.getRol(),
                    "Validación de Rol",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Login exitoso - Abrir FrmPrincipal
        JOptionPane.showMessageDialog(vista,
                "¡Bienvenido " + usuarioLogueado.getNombre() + "!",
                "Login Exitoso",
                JOptionPane.INFORMATION_MESSAGE);

        FrmPrincipal frm = new FrmPrincipal(usuarioLogueado);
        frm.setVisible(true);

        vista.dispose();
    }
}
