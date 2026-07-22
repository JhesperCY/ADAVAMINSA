package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    Connection conectar = null;
 
    String Usuario = "postgres";
    String Contraseña = "Gasparin";
    String NombreBD = "adavaminsa_db";
    String Ip = "localhost";
    String Puerto = "5432";
 
    String cadena = "jdbc:postgresql://" + Ip + ":" + Puerto + "/" + NombreBD;
 
    public Connection establecerConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena, Usuario, Contraseña);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion a Base de Datos:" + e.toString());
        }
        return conectar;
    }
}
