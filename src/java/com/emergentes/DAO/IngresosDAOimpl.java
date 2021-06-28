package com.emergentes.DAO;
import com.emergentes.conexion.Conexione;
import com.emergentes.modelo.Ingresos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IngresosDAOimpl extends Conexione implements IngresosDAO{

    @Override
    public void insert(Ingresos ingre) throws Exception {
        try {
            this.conectar();
            String sql = "insert into ingresos (id, id_cat_ing, fecha, descripcion, cantidad, precio) values (?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ingre.getId());
            ps.setInt(2, ingre.getId_cat_ing());
            ps.setString(3, ingre.getFecha());
            ps.setString(4, ingre.getDescripcion());
            ps.setInt(5, ingre.getCantidad());
            ps.setInt(6, ingre.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en update ingresos"+e.getMessage());;
        } finally {
            this.desconectar();
        }       
    }

    @Override
    public void update(Ingresos ingre) throws Exception {
        try {
            this.conectar();
            String sql = "update ingresos SET id = ?, id_cat_ing = ?, fecha = ?, descripcion = ?, cantidad = ?, precio=? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ingre.getId());
            ps.setInt(2, ingre.getId_cat_ing());
            ps.setString(3, ingre.getFecha());
            ps.setString(4, ingre.getDescripcion());
            ps.setInt(5, ingre.getCantidad());
            ps.setInt(6, ingre.getPrecio());
            ps.setInt(7, ingre.getId());            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en update ingresos"+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
         try {
            this.conectar();
            String sql = "delete from ingresos where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar ingresos");
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Ingresos getById(int id) throws Exception {
        Ingresos ing = new Ingresos();
        try {
            this.conectar();
            String sql = "select * from ingresos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ing.setId(rs.getInt("id"));
                ing.setId_cat_ing(rs.getInt("id_cat_ing"));
                ing.setFecha(rs.getString("fecha"));
                ing.setDescripcion(rs.getString("descripcion"));
                ing.setCantidad(rs.getInt("cantidad"));
                ing.setPrecio(rs.getInt("precio"));
            }
        } catch (Exception e) {
            System.out.println("Error en el by id ingresos: "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return ing;
    }

    @Override
    public int total() throws Exception {
        int total = 0;
        try {
            this.conectar();
            String sql = "SELECT SUM((cantidad*precio)) AS total FROM ingresos ;";
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
    public List<Ingresos> getAll() throws Exception {
        List<Ingresos> lista = null;
        try {
            int dato=0;
            this.conectar();
            String sql = "SELECT cat.nombre AS categoria,ing.* FROM cat_ingre cat "
                    + "INNER JOIN ingresos ing  ON ing.id_cat_ing = cat.id_cat_ing;";
            PreparedStatement ps = this.conn.prepareStatement(sql);           
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Ingresos>();
            while (rs.next()) {
                Ingresos ingre = new Ingresos();                
                ingre.setId(rs.getInt("id"));
                ingre.setId_cat_ing(rs.getInt("id_cat_ing"));
                ingre.setFecha(rs.getString("fecha"));
                ingre.setDescripcion(rs.getString("descripcion"));
                ingre.setCantidad(rs.getInt("cantidad"));
                ingre.setCategoria(rs.getString("categoria"));
                ingre.setPrecio(rs.getInt("precio"));
                dato = ingre.getPrecio()*ingre.getCantidad();
                ingre.setTotal(dato);
                lista.add(ingre);
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
