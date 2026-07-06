package Dao;

import Conexion.Conexion;
import Modelo.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TareaDao {
    Conexion instanciaConexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean asignarTarea(Tarea t) {
        String sql = "INSERT INTO tarea (id_voluntario, id_hospital, fecha, hora, descripcion, estado) VALUES (?,?,?,?,?,?)";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getIdVoluntario());
            ps.setInt(2, t.getIdHospital());
            ps.setString(3, t.getFecha());
            ps.setString(4, t.getHora());
            ps.setString(5, t.getDescripcion());
            ps.setString(6, "Pendiente"); // Estado inicial según flujo de negocio
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la tarea: " + e.toString());
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

    public List<Tarea> listarTareas() {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT * FROM tarea ORDER BY fecha ASC, hora ASC";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea t = new Tarea();
                t.setIdTarea(rs.getInt("id_tarea"));
                t.setIdVoluntario(rs.getInt("id_voluntario"));
                t.setIdHospital(rs.getInt("id_hospital"));
                t.setFecha(rs.getString("fecha"));
                t.setHora(rs.getString("hora"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setEstado(rs.getString("estado"));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
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

    public boolean finalizarTarea(int idTarea) {
        String sql = "UPDATE tarea SET estado = 'Finalizada' WHERE id_tarea = ?";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTarea);
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
