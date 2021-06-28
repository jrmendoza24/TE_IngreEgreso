package com.emergente.controlador;
import com.emergentes.DAO.Cat_ingDAO;
import com.emergentes.DAO.Cat_ingDAOimpl;
import com.emergentes.modelo.Cat_ingre;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ProcesaCategoriaIngreso", urlPatterns = {"/ProcesaCategoriaIngreso"})
public class ProcesaCategoriaIngreso extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Cat_ingre catingre = new Cat_ingre();
            int id;
            Cat_ingDAO dao = new Cat_ingDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("categoria_ingresos_get", catingre);
                    request.getRequestDispatcher("form_cat_ingr.jsp").forward(request, response);
                    break;
                case "edit":                    
                    id = Integer.parseInt(request.getParameter("id"));
                    catingre = dao.getById(id);
                    request.setAttribute("categoria_ingresos_get", catingre);
                    request.getRequestDispatcher("form_cat_ingr.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProcesaCategoriaIngreso");
                    break;
                case "view":
                    List<Cat_ingre> lista = dao.getAll();
                    request.setAttribute("categoria_ingresos", lista);
                    request.getRequestDispatcher("cat_ingre.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }  
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        Cat_ingre cat_ingre = new Cat_ingre();
       
        cat_ingre.setId_cat_ing(id);
        cat_ingre.setNombre(nombre);
        cat_ingre.setFecha(fecha);

        Cat_ingDAO dao = new Cat_ingDAOimpl();
        if (id == 0) {
            try {
                dao.insert(cat_ingre);
            } catch (Exception ex) {
                System.out.println("Error al insertar procesacategoriaingreso" + ex.getMessage());
            }
        } else {
            try {
                // Edicion de registro
                dao.update(cat_ingre);
            } catch (Exception ex) {
                System.out.println("Error al editar procesacategoriaingreso" + ex.getMessage());
            }
        }
        response.sendRedirect("ProcesaCategoriaIngreso");
    }
}
