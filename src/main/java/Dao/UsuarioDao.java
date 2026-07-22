package Dao;

import Conexion.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDao {
    Conexion instanciaConexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Usuario login(String nombreUsuario, String password) {
        Usuario user = null;
        String sql = "SELECT * FROM usuario WHERE nombre_usuario = ? AND password = ?";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new Usuario();
                user.setIdUsuario(rs.getInt("id_usuario"));
                user.setNombreUsuario(rs.getString("nombre_usuario"));
                user.setPassword(rs.getString("password"));
                user.setRol(rs.getString("rol"));
                user.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al validar acceso: " + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return user;
    }

    public boolean actualizarPerfil(Usuario u) {
        String sql = "UPDATE usuario SET nombre = ? WHERE id_usuario = ?";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getIdUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar perfil: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean cambiarPassword(int idUsuario, String passwordActual, String passwordNueva) {
        String sqlVerificar = "SELECT id_usuario FROM usuario WHERE id_usuario = ? AND password = ?";
        String sqlActualizar = "UPDATE usuario SET password = ? WHERE id_usuario = ?";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sqlVerificar);
            ps.setInt(1, idUsuario);
            ps.setString(2, passwordActual);
            rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "La contraseña actual no es correcta.");
                return false;
            }
            ps = con.prepareStatement(sqlActualizar);
            ps.setString(1, passwordNueva);
            ps.setInt(2, idUsuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cambiar la contraseña: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
