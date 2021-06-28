package com.emergentes.DAO;
import com.emergentes.modelo.Ingresos;
import java.util.List;
public interface IngresosDAO {
    public void insert(Ingresos ingre) throws Exception;
    public void update(Ingresos ingre) throws Exception;
    public void delete(int id) throws Exception;
    public Ingresos getById(int id) throws Exception;
    public int total()throws Exception;
    public List<Ingresos> getAll() throws Exception;   
}
