package com.emergentes.DAO;
import com.emergentes.modelo.Cat_egresos;
import java.util.List;
public interface Cat_egresosDAO {
    public void insert(Cat_egresos egreso) throws Exception;
    public void update(Cat_egresos egreso) throws Exception;
    public void delete(int id) throws Exception;
    public Cat_egresos getById(int id) throws Exception;
    public List<Cat_egresos> getAll() throws Exception;       
}
