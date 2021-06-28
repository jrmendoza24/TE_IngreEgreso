package com.emergentes.DAO;

import com.emergentes.modelo.Cat_ingre;
import java.util.List;

public interface Cat_ingDAO {
    public void insert(Cat_ingre ingre) throws Exception;
    public void update(Cat_ingre ingre) throws Exception;
    public void delete(int id) throws Exception;
    public Cat_ingre getById(int id) throws Exception;
    public List<Cat_ingre> getAll() throws Exception;   
}
