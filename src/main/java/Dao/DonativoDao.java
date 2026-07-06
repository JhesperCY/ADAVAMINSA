package Dao;

import Conexion.Conexion;
import Modelo.Donativo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DonativoDao {
    Conexion instanciaConexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrarDonativo(Donativo d) {
        String sql = "INSERT INTO donativo (id_donante, id_medicina, fecha, cantidad, observaciones) VALUES (?,?,?,?,?)";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, d.getIdDonante());
            ps.setInt(2, d.getIdMedicina());
            ps.setString(3, d.getFecha());
            ps.setInt(4, d.getCantidad());
            ps.setString(5, d.getObservaciones());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el historial de donación: " + e.toString());
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

    public List<Donativo> listarHistorial() {
        List<Donativo> lista = new ArrayList<>();
        String sql = "SELECT * FROM donativo ORDER BY fecha DESC";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Donativo d = new Donativo();
                d.setIdDonativo(rs.getInt("id_donativo"));
                d.setIdDonante(rs.getInt("id_donante"));
                d.setIdMedicina(rs.getInt("id_medicina"));
                d.setFecha(rs.getString("fecha"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setObservaciones(rs.getString("observaciones"));
                lista.add(d);
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
