package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    private PreparedStatement ps = null;
    private Connection con = null;
    private ResultSet rs = null;
    
    
    //Ubuntu Server PostgreSQL Server from AWS
    String Database = "serveoCRM",UrlCon = "jdbc:postgresql://52.90.219.152:5432/"+Database,User = "serveoadmin",Pass = "12345", driver = "org.postgresql.Driver";
    
    //Local Computer PostgreSQL Server
    //String Database = "serveoCRM", UrlCon = "jdbc:postgresql://localhost:5432/" + Database,User = "serveoAdmin",Pass = "12345",driver = "org.postgresql.Driver";
    
    
    public Connection open() throws ClassNotFoundException {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(UrlCon, User, Pass);
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Excepcion: " + e.getMessage());
        }
        return con;
    }

    public void close() throws Exception {
        try {
            if (con != null) {
                con.clearWarnings();
                con.close();
            }
        } catch (SQLException e) {
            con = null;
            throw new Exception(e.getMessage());
        }
    }

    public boolean executeSql(String cmd) {
        if (cmd != null) {
            try {
                this.ps = this.con.prepareStatement(cmd);
                this.ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }

    public ResultSet executeQuery(String strSQL) {
        if (strSQL != null) {
            try {
                ps = con.prepareStatement(strSQL);
                rs = ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Error al ejecutar el query en la clase: Conexion \n Mensaje de Error:" + e.toString());
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return rs;
    }
}
