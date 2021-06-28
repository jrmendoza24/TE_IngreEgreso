package com.emergentes.DAO;

import com.emergentes.conexion.Conexione;
import com.emergentes.modelo.Egresos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EgresosDAOimpl extends Conexione implements EgresosDAO{

    @Override
    public void insert(Egresos egreso) throws Exception {
        try {
            this.conectar();
            String sql = "insert into egresos (id, id_cat_egresos, fecha, descripcion, cantidad, precio) values (?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, egreso.getId());
            ps.setInt(2, egreso.getId_cat_egresos());
            ps.setString(3, egreso.getFecha());
            ps.setString(4, egreso.getDescripcion());
            ps.setInt(5, egreso.getCantidad());
            ps.setInt(6, egreso.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en insert egresos"+e.getMessage());;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Egresos egreso) throws Exception {
        try {
            this.conectar();
            String sql = "update egresos SET id = ?, id_cat_egresos = ?, fecha = ?, descripcion = ?, cantidad = ?, precio=? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, egreso.getId());
            ps.setInt(2, egreso.getId_cat_egresos());
            ps.setString(3, egreso.getFecha());
            ps.setString(4, egreso.getDescripcion());
            ps.setInt(5, egreso.getCantidad());
            ps.setInt(6, egreso.getPrecio());
            ps.setInt(7, egreso.getId());            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en update egresos"+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
         try {
            this.conectar();
            String sql = "delete from egresos where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar egresos");
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Egresos getById(int id) throws Exception {
        Egresos egreso = new Egresos();
        try {
            this.conectar();
            String sql = "select * from egresos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                egreso.setId(rs.getInt("id"));
                egreso.setId_cat_egresos(rs.getInt("id_cat_egresos"));
                egreso.setFecha(rs.getString("fecha"));
                egreso.setDescripcion(rs.getString("descripcion"));
                egreso.setCantidad(rs.getInt("cantidad"));
                egreso.setPrecio(rs.getInt("precio"));
            }
        } catch (Exception e) {
            System.out.println("Error en el by id egresos: "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return egreso;
    }

    @Override
    public int total() throws Exception {
        int total = 0;
        try {
            this.conectar();
            String sql = "SELECT SUM((cantidad*precio)) AS total FROM egresos ;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total= rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("Error en el total "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return total;
    }

    @Override
    public List<Egresos> getAll() throws Exception {
                List<Egresos> lista = null;
        try {
            int dato=0;
            this.conectar();
            String sql = "SELECT cat.nombre AS categoria,egres.* FROM cat_egresos cat "
                    + "INNER JOIN egresos egres  ON egres.id_cat_egresos = cat.id_cat_egresos;";
            PreparedStatement ps = this.conn.prepareStatement(sql);           
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Egresos>();
            while (rs.next()) {
                Egresos egresos = new Egresos();                
                egresos.setId(rs.getInt("id"));
                egresos.setId_cat_egresos(rs.getInt("id_cat_egresos"));
                egresos.setFecha(rs.getString("fecha"));
                egresos.setDescripcion(rs.getString("descripcion"));
                egresos.setCantidad(rs.getInt("cantidad"));
                egresos.setCategoria(rs.getString("categoria"));
                egresos.setPrecio(rs.getInt("precio"));
                dato = egresos.getPrecio()*egresos.getCantidad();
                egresos.setTotal(dato);
                lista.add(egresos);
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
