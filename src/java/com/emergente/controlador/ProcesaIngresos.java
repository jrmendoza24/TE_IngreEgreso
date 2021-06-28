package com.emergente.controlador;
import com.emergentes.DAO.Cat_ingDAO;
import com.emergentes.DAO.Cat_ingDAOimpl;
import com.emergentes.DAO.IngresosDAO;
import com.emergentes.DAO.IngresosDAOimpl;
import com.emergentes.modelo.Cat_ingre;
import com.emergentes.modelo.Ingresos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcesaIngresos", urlPatterns = {"/ProcesaIngresos"})
public class ProcesaIngresos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               try{
            Cat_ingDAO dao = new Cat_ingDAOimpl();
            IngresosDAO daoIngresos = new IngresosDAOimpl();
            int total=0;
            int id;            
            List<Cat_ingre> lista_cat_ingre = null;
            List<Ingresos> lista_ingresos = null;     
            Ingresos ingresos = new Ingresos();            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    lista_cat_ingre = dao.getAll();                   
                    request.setAttribute("lista_ingresos", lista_cat_ingre);
                    request.setAttribute("ingresos",ingresos);
                    request.getRequestDispatcher("form_ingresos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    ingresos = daoIngresos.getById(id);
                    lista_cat_ingre = dao.getAll();
                    request.setAttribute("lista_ingresos", lista_cat_ingre);                    
                    request.setAttribute("ingresos",ingresos);
                    request.getRequestDispatcher("form_ingresos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    daoIngresos.delete(id);
                    response.sendRedirect("ProcesaIngresos");
                    break;
                case "lista":
                    total = daoIngresos.total();
                    request.setAttribute("totalingresos", total);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "view":
                    List<Ingresos> lista = daoIngresos.getAll();
                    request.setAttribute("ingresos", lista);
                    request.getRequestDispatcher("ingresos.jsp").forward(request, response);
                    break;                    
            }
        }catch(Exception ex){
            System.out.println("Error fatal en ingresos" + ex.getMessage());
        }        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_cat_ing = Integer.parseInt(request.getParameter("id_ingreso"));
        int precio = Integer.parseInt(request.getParameter("precio"));
        String fecha = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String categoria = request.getParameter("categoria");             
        
        Ingresos ingre = new Ingresos();
        
        ingre.setId(id);
        ingre.setId_cat_ing(id_cat_ing);
        ingre.setFecha(fecha);
        ingre.setDescripcion(descripcion);
        ingre.setCantidad(cantidad);
        ingre.setCategoria(categoria);
        ingre.setPrecio(precio);
        
        if(id == 0){
            // Nuevo
            IngresosDAO dao = new IngresosDAOimpl();
            try {
                dao.insert(ingre);
                response.sendRedirect("ProcesaIngresos");
            } catch (Exception ex) {
                System.out.println("Error ingresos"+ex.getMessage());
            }
        }
        else{
            //Editar
            IngresosDAO dao = new IngresosDAOimpl();
            try {
                dao.update(ingre);
                response.sendRedirect("ProcesaIngresos");
            } catch (Exception ex) {
                System.out.println("Error ingresos");
            } 
    }
    }
}
