package Dao;

import Conexion.Conexion;
import Modelo.Voluntario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VoluntarioDao {
    Conexion instanciaConexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;


    public boolean registrar(Voluntario v) {
        String sql = "INSERT INTO voluntario (dni, nombre, apellido, telefono, especialidad, disponibilidad, estado, horas_servicio) VALUES (?,?,?,?,?,?,?,?)";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getDni());
            ps.setString(2, v.getNombre());
            ps.setString(3, v.getApellido());
            ps.setString(4, v.getTelefono());
            ps.setString(5, v.getEspecialidad());
            ps.setString(6, v.getDisponibilidad());
            ps.setString(7, "Activo"); // Postcondición del CUS-05
            ps.setInt(8, 0);           // Inicia con cero horas
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar voluntario: " + e.toString());
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

    public List<Voluntario> buscarPorEspecialidad(String especialidad) {
        List<Voluntario> lista = new ArrayList<>();
        String sql = "SELECT * FROM voluntario WHERE especialidad = ?";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, especialidad);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voluntario v = new Voluntario();
                v.setIdVoluntario(rs.getInt("id_voluntario"));
                v.setDni(rs.getString("dni"));
                v.setNombre(rs.getString("nombre"));
                v.setApellido(rs.getString("apellido"));
                v.setTelefono(rs.getString("telefono"));
                v.setEspecialidad(rs.getString("especialidad"));
                v.setDisponibilidad(rs.getString("disponibilidad"));
                v.setEstado(rs.getString("estado"));
                v.setHorasServicio(rs.getInt("horas_servicio"));
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la búsqueda: " + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return lista;
    }
    
    public List<Voluntario> listarTodos() {
        List<Voluntario> lista = new ArrayList<>();
        String sql = "SELECT * FROM voluntario ORDER BY apellido, nombre";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voluntario v = new Voluntario();
                v.setIdVoluntario(rs.getInt("id_voluntario"));
                v.setDni(rs.getString("dni"));
                v.setNombre(rs.getString("nombre"));
                v.setApellido(rs.getString("apellido"));
                v.setTelefono(rs.getString("telefono"));
                v.setEspecialidad(rs.getString("especialidad"));
                v.setDisponibilidad(rs.getString("disponibilidad"));
                v.setEstado(rs.getString("estado"));
                v.setHorasServicio(rs.getInt("horas_servicio"));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
        return lista;
    }

    public boolean actualizarEstado(int id, String nuevoEstado) {
        String sql = "UPDATE voluntario SET estado = ? WHERE id_voluntario = ?";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevoEstado);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
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
