package com.emergentes.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexione {
   static String url = "jdbc:mysql://localhost:3306/bd_egresoingreso";
    static String driver = "com.mysql.jdbc.Driver";
    static String usuario = "root";
    static String password = "";        
    
    protected Connection conn = null;
    public Conexione(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexione.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en el driver"+ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Conexione.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en el sql"+ex.getMessage());
        }                
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexione.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al desconectar"+ex.getMessage());
        }
    }    
}
