package com.emergentes.conexion;

import com.emergentes.modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Validacion extends Conexione{
    Connection con = this.conectar();
    PreparedStatement pr;
    
    public boolean checkUser(String email, String password)
    {
        boolean resultado = false;
        try {
            String sql = "select * from usuarios where email=? and password=sha1(?)";
            
            pr = con.prepareStatement(sql);
            pr.setString(1,email);
            pr.setString(2,password);
            ResultSet rs =  pr.executeQuery();
            resultado = rs.next();
        } catch (SQLException ex) {
            System.out.println(""
                    + "Error al autenticar");
        }
        return resultado;
    }
    public int id_user(String email, String password){
        int valor = 0;
        try {
            Usuarios user= new Usuarios();
            String sql = "select id_user from usuarios where email=? and password=sha1(?)";            
            pr = con.prepareStatement(sql);
            pr.setString(1,email);
            pr.setString(2,password);
            ResultSet rs =  pr.executeQuery();
            if (rs.next()) {
                user.setId_user(rs.getInt("id_user"));
                valor = user.getId_user();
            }
        } catch (SQLException ex) {
            System.out.println(""
                    + "Error al autenticar");
        }
        return valor;
    }
    
    public int id(String email, String password){
        int valor = 0;
        try {
            Usuarios user= new Usuarios();
            String sql = "select id from usuarios where email=? and password=sha1(?)";            
            pr = con.prepareStatement(sql);
            pr.setString(1,email);
            pr.setString(2,password);
            ResultSet rs =  pr.executeQuery();
            if (rs.next()) {
                user.setId_user(rs.getInt("id"));
                valor = user.getId_user();
            }
        } catch (SQLException ex) {
            System.out.println(""
                    + "Error al autenticar");
        }
        return valor;
    }
}
