package com.emergentes.DAO;

import com.emergentes.conexion.Conexione;
import com.emergentes.modelo.Cat_ingre;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Cat_ingDAOimpl extends Conexione implements Cat_ingDAO{

    @Override
    public void insert(Cat_ingre ingre) throws Exception {
        try {
            this.conectar();
            String sql = "insert into cat_ingre(nombre,fecha) values(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,ingre.getNombre());
            ps.setString(2,ingre.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en categoria ingreso al insertar");
        }finally{
        this.desconectar();
        }
    }

    @Override
    public void update(Cat_ingre ingre) throws Exception {
        try {
            this.conectar();
            String sql = "update cat_ingre set nombre=?,fecha=? where id_cat_ing=? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);            
            ps.setString(1,ingre.getNombre());
            ps.setString(2,ingre.getFecha());
            ps.setInt(3, ingre.getId_cat_ing());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al update categoreia ingreso"+e.getMessage());
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from cat_ingre where id_cat_ing = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar categoria ingresos"+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cat_ingre getById(int id) throws Exception {
        Cat_ingre cat_ingre = new Cat_ingre();
        try {
            this.conectar();
            String sql = "select * from cat_ingre where id_cat_ing = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            cat_ingre.setId_cat_ing(rs.getInt("id_cat_ing"));
            cat_ingre.setNombre(rs.getString("nombre"));
            cat_ingre.setFecha(rs.getString("fecha"));
            cat_ingre.toString();
            }
        } catch (Exception e) {
            System.out.println("Error en el by id categoria ingresos"+e.getMessage());
        }finally{
            this.desconectar();
        }return cat_ingre;
    }

    @Override
    public List<Cat_ingre> getAll() throws Exception {
        List<Cat_ingre> lista = null; 
        try {
            this.conectar();
            String sql = "select * from cat_ingre";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Cat_ingre>(); 
            while(rs.next()){
            Cat_ingre cat_ingre = new Cat_ingre();    
            cat_ingre.setId_cat_ing(rs.getInt("id_cat_ing"));
            cat_ingre.setNombre(rs.getString("nombre"));
            cat_ingre.setFecha(rs.getString("fecha"));
            lista.add(cat_ingre);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en el select en cat ingre"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return lista;        
    }
 
}
