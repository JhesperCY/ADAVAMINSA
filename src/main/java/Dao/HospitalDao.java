package Dao;

import Conexion.Conexion;
import Modelo.Hospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalDao {
    
    Conexion instanciaConexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Hospital> listarTodos() {
        List<Hospital> lista = new ArrayList<>();
        String sql = "SELECT * FROM hospital ORDER BY nombre ASC";
        try {
            con = instanciaConexion.establecerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Hospital h = new Hospital();
                h.setIdHospital(rs.getInt("id_hospital"));
                h.setNombre(rs.getString("nombre"));
                h.setDireccion(rs.getString("direccion"));
                h.setTelefono(rs.getString("telefono"));
                h.setRedSalud(rs.getString("red_salud"));
                lista.add(h);
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
