package Dao;

import Conexion.Conexion;
import Modelo.Medicina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MedicinaDao {
    Conexion instanciaConexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Medicina m) {
        String sql = "INSERT INTO medicina (nombre, lote, fecha_vencimiento, cantidad, categoria) VALUES (?,?,?::date,?,?)";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getLote());
            ps.setString(3, m.getFechaVencimiento());
            ps.setInt(4, m.getCantidad());
            ps.setString(5, m.getCategoria());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar medicina: " + e.toString());
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

    public boolean actualizarStock(int id, int nuevaCantidad) {
        String sql = "UPDATE medicina SET cantidad = cantidad + ? WHERE id_medicina = ?";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nuevaCantidad);
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

    /**
     * Reemplaza todos los datos de una medicina ya existente (botón Editar).
     */
    public boolean actualizar(Medicina m) {
        String sql = "UPDATE medicina SET nombre=?, lote=?, fecha_vencimiento=?::date, cantidad=?, categoria=? WHERE id_medicina=?";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getLote());
            ps.setString(3, m.getFechaVencimiento());
            ps.setInt(4, m.getCantidad());
            ps.setString(5, m.getCategoria());
            ps.setInt(6, m.getIdMedicina());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar medicina: " + e.toString());
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

    public boolean eliminar(int idMedicina) {
        String sql = "DELETE FROM medicina WHERE id_medicina = ?";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMedicina);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar medicina: " + e.toString());
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

    public List<Medicina> listarMedicinas() {
        List<Medicina> lista = new ArrayList<>();
        String sql = "SELECT * FROM medicina ORDER BY nombre ASC";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicina m = new Medicina();
                m.setIdMedicina(rs.getInt("id_medicina"));
                m.setNombre(rs.getString("nombre"));
                m.setLote(rs.getString("lote"));
                m.setFechaVencimiento(rs.getString("fecha_vencimiento"));
                m.setCantidad(rs.getInt("cantidad"));
                m.setCategoria(rs.getString("categoria"));
                lista.add(m);
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

    public List<Medicina> listarPorVencer() {
        List<Medicina> lista = new ArrayList<>();
        String sql = "SELECT * FROM medicina WHERE CAST(fecha_vencimiento AS DATE) <= CURRENT_DATE + INTERVAL '3 months'";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicina m = new Medicina();
                m.setIdMedicina(rs.getInt("id_medicina"));
                m.setNombre(rs.getString("nombre"));
                m.setLote(rs.getString("lote"));
                m.setFechaVencimiento(rs.getString("fecha_vencimiento"));
                m.setCantidad(rs.getInt("cantidad"));
                lista.add(m);
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
}
