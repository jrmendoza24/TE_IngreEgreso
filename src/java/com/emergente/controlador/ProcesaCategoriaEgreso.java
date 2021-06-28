package com.emergente.controlador;
import com.emergentes.DAO.Cat_egresosDAO;
import com.emergentes.DAO.Cat_egresosDAOimpl;
import com.emergentes.modelo.Cat_egresos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ProcesaCategoriaEgreso", urlPatterns = {"/ProcesaCategoriaEgreso"})
public class ProcesaCategoriaEgreso extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Cat_egresos catingre = new Cat_egresos();
            int id;
            Cat_egresosDAO dao = new Cat_egresosDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("categoria_egresos_get", catingre);
                    request.getRequestDispatcher("form_cat_egreso.jsp").forward(request, response);
                    break;
                case "edit":                    
                    id = Integer.parseInt(request.getParameter("id"));
                    catingre = dao.getById(id);
                    request.setAttribute("categoria_egresos_get", catingre);
                    request.getRequestDispatcher("form_cat_egreso.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProcesaCategoriaEgreso");
                    break;
                case "view":
                    List<Cat_egresos> lista = dao.getAll();
                    request.setAttribute("categoria_egresos", lista);
                    request.getRequestDispatcher("cat_egresos.jsp").forward(request, response);                    
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProcesaCategoriaEgreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        Cat_egresos cat_egreso = new Cat_egresos();       
        cat_egreso.setId(id);
        cat_egreso.setNombre(nombre);
        cat_egreso.setFecha(fecha);

        Cat_egresosDAO dao = new Cat_egresosDAOimpl();
        if (id == 0) {
            try {
                dao.insert(cat_egreso);
            } catch (Exception ex) {
                System.out.println("Error al insertar procesacategoriaegreso" + ex.getMessage());
            }
        } else {
            try {
                // Edicion de registro
                dao.update(cat_egreso);
            } catch (Exception ex) {
                System.out.println("Error al editar procesacategoriaegreso" + ex.getMessage());
            }
        }
        response.sendRedirect("ProcesaCategoriaEgreso");
    }
}
