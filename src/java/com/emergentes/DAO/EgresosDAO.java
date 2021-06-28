package com.emergentes.DAO;

import com.emergentes.modelo.Egresos;
import java.util.List;

public interface EgresosDAO {
    public void insert(Egresos egreso) throws Exception;
    public void update(Egresos egreso) throws Exception;
    public void delete(int id) throws Exception;
    public Egresos getById(int id) throws Exception;
    public int total()throws Exception;
    public List<Egresos> getAll() throws Exception;      
}
