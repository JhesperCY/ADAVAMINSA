package Dao;

import Conexion.Conexion;
import Modelo.Donante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DonanteDao {
    
    Conexion instanciaConexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Donante d) {
        String sql = "INSERT INTO donante (nombre, tipo_donante, ruc_dni, direccion, telefono, correo) VALUES (?,?,?,?,?,?)";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getTipoDonante());
            ps.setString(3, d.getRucDni());
            ps.setString(4, d.getDireccion());
            ps.setString(5, d.getTelefono());
            ps.setString(6, d.getCorreo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar donante: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public List<Donante> listarTodos() {
        List<Donante> lista = new ArrayList<>();
        String sql = "SELECT * FROM donante ORDER BY nombre";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Donante d = new Donante();
                d.setIdDonante(rs.getInt("id_donante"));
                d.setNombre(rs.getString("nombre"));
                d.setTipoDonante(rs.getString("tipo_donante"));
                d.setRucDni(rs.getString("ruc_dni"));
                d.setDireccion(rs.getString("direccion"));
                d.setTelefono(rs.getString("telefono"));
                d.setCorreo(rs.getString("correo"));
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
            }
        }
        return lista;
    }
    
}
