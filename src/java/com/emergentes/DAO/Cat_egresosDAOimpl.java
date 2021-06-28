package com.emergentes.DAO;
import com.emergentes.conexion.Conexione;
import com.emergentes.modelo.Cat_egresos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Cat_egresosDAOimpl extends Conexione implements Cat_egresosDAO{

    @Override
    public void insert(Cat_egresos egreso) throws Exception {
        try {
            this.conectar();
            String sql = "insert into cat_egresos(nombre,fecha) values(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,egreso.getNombre());
            ps.setString(2,egreso.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en categoria egreso al insertar"+e.getMessage());
        }finally{
        this.desconectar();
        }

    }

    @Override
    public void update(Cat_egresos egreso) throws Exception {
        try {
            this.conectar();
            String sql = "update cat_egresos set nombre=?,fecha=? where id_cat_egresos=? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);            
            ps.setString(1,egreso.getNombre());
            ps.setString(2,egreso.getFecha());
            ps.setInt(3, egreso.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al update categoria egreso"+e.getMessage());
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from cat_egresos where id_cat_egresos = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar categoria egresos"+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cat_egresos getById(int id) throws Exception {
            Cat_egresos egresos = new Cat_egresos();
        try {
            this.conectar();
            String sql = "select * from cat_egresos where id_cat_egresos = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            egresos.setId(rs.getInt("id_cat_egresos"));
            egresos.setNombre(rs.getString("nombre"));
            egresos.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
            System.out.println("Error en el by id categoria egresos"+e.getMessage());
        }finally{
            this.desconectar();
        }return egresos;
    }

    @Override
    public List<Cat_egresos> getAll() throws Exception {
        List<Cat_egresos> lista = null; 
        try {
            this.conectar();
            String sql = "select * from cat_egresos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Cat_egresos>(); 
            while(rs.next()){
            Cat_egresos cat_ingre = new Cat_egresos();    
            cat_ingre.setId(rs.getInt("id_cat_egresos"));
            cat_ingre.setNombre(rs.getString("nombre"));
            cat_ingre.setFecha(rs.getString("fecha"));
            lista.add(cat_ingre);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en el select en cat egreso"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return lista; 
    }

}
