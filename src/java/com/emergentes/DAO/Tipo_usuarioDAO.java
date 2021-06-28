package com.emergentes.DAO;

import com.emergentes.modelo.Tipo_usuario;
import java.util.List;

public interface Tipo_usuarioDAO {
    public void insert(Tipo_usuario tip_user) throws Exception;
    public void update(Tipo_usuario tip_user) throws Exception;
    public void delete(int id) throws Exception;
    public Tipo_usuario getById(int id) throws Exception;
    public List<Tipo_usuario> getAll() throws Exception;  
}
