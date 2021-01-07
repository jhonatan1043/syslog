/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programador 1
 */
public class Conexion {

    String driver;
    String url;
    String host = "localhost:1433";
    String db = "SISlog";
    String user = "Syslog";
    String pass = "123456789";

    public Connection getConexion() {
        Connection cnx = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            url = "jdbc:sqlserver://" + host + ";databaseName=" + db
                    + ";user=" + user + ";password=" + pass + ";";
            try {

                cnx = DriverManager.getConnection(url);
                System.out.println("Conexion exitosa");

            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }
}
