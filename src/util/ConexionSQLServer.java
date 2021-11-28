/* Autor: Camilo Andres Riaño Pallares
 */
package util;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLServer {

    public static String url = "jdbc:postgresql://192.168.56.1:5432/Liga";
    //public static String BASEDATOS = "Liga";
    public static String USUARIO = "postgres";
    public static String CLAVE = "12345";

    /*public static Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://192.168.56.1:5432/" + BASEDATOS, USUARIO, CLAVE);
        
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void desconexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }*/
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, USUARIO, CLAVE);
            System.out.println("Conexion con exito");

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Error" + e);
        }
        return con;
    }

    public static void desconectar() {
        Connection con = null;
        if (con == null) {
            System.out.println("La variable a sido puesta en null");
        }
    }
    
}
