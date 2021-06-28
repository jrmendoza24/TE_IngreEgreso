package com.emergente.controlador;

import com.emergentes.DAO.Cat_egresosDAO;
import com.emergentes.DAO.Cat_egresosDAOimpl;
import com.emergentes.DAO.EgresosDAO;
import com.emergentes.DAO.EgresosDAOimpl;
import com.emergentes.modelo.Cat_egresos;
import com.emergentes.modelo.Egresos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ProcesaEgreso", urlPatterns = {"/ProcesaEgreso"})
public class ProcesaEgreso extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Cat_egresosDAO dao = new Cat_egresosDAOimpl();
            EgresosDAO daoEgresos = new EgresosDAOimpl();
            int total=0;
            int id;            
            List<Cat_egresos> lista_cat_egreso = null;
            List<Egresos> lista_egresos = null;     
            Egresos egresos = new Egresos();            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    lista_cat_egreso = dao.getAll();                   
                    request.setAttribute("lista_egresos", lista_cat_egreso);
                    request.setAttribute("egresos",egresos);
                    request.getRequestDispatcher("form_egresos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    egresos = daoEgresos.getById(id);
                    lista_cat_egreso = dao.getAll();
                    request.setAttribute("lista_egresos", lista_cat_egreso);                    
                    request.setAttribute("egresos",egresos);
                    request.getRequestDispatcher("form_egresos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    daoEgresos.delete(id);
                    response.sendRedirect("ProcesaEgreso");
                    break;
                case "lista":
                    total = daoEgresos.total();
                    request.setAttribute("totalEgresos", total);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "view":
                    List<Egresos> lista = daoEgresos.getAll();
                    request.setAttribute("egresos", lista);
                    request.getRequestDispatcher("egresos.jsp").forward(request, response);
                    break;                    
            }
        }catch(Exception ex){
            System.out.println("Error fatal en egresos" + ex.getMessage());
        } 
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_cat_egreso = Integer.parseInt(request.getParameter("id_egresos"));
        int precio = Integer.parseInt(request.getParameter("precio"));
        String fecha = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String categoria = request.getParameter("categoria");             
        
        Egresos ingre = new Egresos();
        
        ingre.setId(id);
        ingre.setId_cat_egresos(id_cat_egreso);
        ingre.setFecha(fecha);
        ingre.setDescripcion(descripcion);
        ingre.setCantidad(cantidad);
        ingre.setCategoria(categoria);
        ingre.setPrecio(precio);
        
        if(id == 0){
            // Nuevo
            EgresosDAO dao = new EgresosDAOimpl();
            try {
                dao.insert(ingre);
                response.sendRedirect("ProcesaEgreso");
            } catch (Exception ex) {
                System.out.println("Error egresos"+ex.getMessage());
            }
        }
        else{
            //Editar
            EgresosDAO dao = new EgresosDAOimpl();
            try {
                dao.update(ingre);
                response.sendRedirect("ProcesaEgreso");
            } catch (Exception ex) {
                System.out.println("Error egresos");
            } 
    }
    }
}
