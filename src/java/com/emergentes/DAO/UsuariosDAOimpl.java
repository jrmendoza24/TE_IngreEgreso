package com.emergentes.DAO;

import com.emergentes.conexion.Conexione;
import com.emergentes.modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOimpl extends Conexione implements UsuariosDAO{

    @Override
    public void insert(Usuarios user) throws Exception {
        try {
            this.conectar();
            String sql = "insert into usuarios (id, nombre_apellido, ci, celular, fecha_nac, email, password, id_user) values (?,?,?,?,?,?,sha1(?),?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getNombre_apellido());
            ps.setInt(3, user.getCi());
            ps.setInt(4, user.getCelular());
            ps.setString(5, user.getFecha_nac());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getId_user());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en update ingresos"+e.getMessage());;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuarios user) throws Exception {
        try {
            this.conectar();
            String sql = "update usuarios SET id=?, nombre_apellido=?, ci=?, celular=?, fecha_nac=?, email=?, password=sha1(?), id_user=? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getNombre_apellido());
            ps.setInt(3, user.getCi());
            ps.setInt(4, user.getCelular());
            ps.setString(5, user.getFecha_nac());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getId_user());
            ps.setInt(9, user.getId());            
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
            String sql = "delete from usuarios where id = ? ";
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
    public Usuarios getById(int id) throws Exception {
        Usuarios user = new Usuarios();
        try {
            this.conectar();
            String sql = "select * from usuarios where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNombre_apellido(rs.getString("nombre_apellido"));
                user.setCi(rs.getInt("ci"));
                user.setCelular(rs.getInt("celular"));
                user.setFecha_nac(rs.getString("fecha_nac"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setId_user(rs.getInt("id_user"));
            }
        } catch (Exception e) {
            System.out.println("Error en el by id ingresos: "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return user;
    }

    @Override
    public List<Usuarios> getAll() throws Exception {
        List<Usuarios> lista = null;
        try {
            int dato=0;
            this.conectar();
            String sql = "SELECT tip.tipo_usuario,user.* FROM tipo_usuario tip "
                    + "INNER JOIN usuarios user  ON user.id_user = tip.id_user;";
            PreparedStatement ps = this.conn.prepareStatement(sql);           
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Usuarios>();
            while (rs.next()) {
                Usuarios user = new Usuarios();                
                user.setId(rs.getInt("id"));
                user.setNombre_apellido(rs.getString("nombre_apellido"));
                user.setCi(rs.getInt("ci"));
                user.setCelular(rs.getInt("celular"));
                user.setFecha_nac(rs.getString("fecha_nac"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setId_user(rs.getInt("id_user"));
                user.setTipo_usuario(rs.getString("tipo_usuario"));
                lista.add(user);
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
