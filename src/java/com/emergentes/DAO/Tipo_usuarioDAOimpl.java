package com.emergentes.DAO;

import com.emergentes.conexion.Conexione;
import com.emergentes.modelo.Tipo_usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tipo_usuarioDAOimpl extends Conexione implements Tipo_usuarioDAO{

    @Override
    public void insert(Tipo_usuario tip_user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Tipo_usuario tip_user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tipo_usuario getById(int id) throws Exception {
        Tipo_usuario tip_user = new Tipo_usuario();
        try {
            this.conectar();
            String sql = "select * from tipo_usuario where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tip_user.setId_user(rs.getInt("id"));
                tip_user.setTipo_usuario(rs.getString("tipo_usuario"));
            }
        } catch (Exception e) {
            System.out.println("Error en el by id ingresos: "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return tip_user;
    }

    @Override
    public List<Tipo_usuario> getAll() throws Exception {
        List<Tipo_usuario> lista = null;
        try {
            int dato=0;
            this.conectar();
            String sql = "SELECT * FROM tipo_usuario;";
            PreparedStatement ps = this.conn.prepareStatement(sql);           
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Tipo_usuario>();
            while (rs.next()) {
                Tipo_usuario tip_user = new Tipo_usuario();                
                tip_user.setId_user(rs.getInt("id_user"));
                tip_user.setTipo_usuario(rs.getString("tipo_usuario"));
                lista.add(tip_user);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en get all ingresos"+e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
