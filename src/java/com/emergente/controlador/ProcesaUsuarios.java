package com.emergente.controlador;

import com.emergentes.DAO.Tipo_usuarioDAO;
import com.emergentes.DAO.Tipo_usuarioDAOimpl;
import com.emergentes.DAO.UsuariosDAO;
import com.emergentes.DAO.UsuariosDAOimpl;
import com.emergentes.modelo.Tipo_usuario;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcesaUsuarios", urlPatterns = {"/ProcesaUsuarios"})
public class ProcesaUsuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Tipo_usuarioDAO dao = new Tipo_usuarioDAOimpl();
            UsuariosDAO daoUsuarios = new UsuariosDAOimpl();
            int total = 0;
            int id;
            List<Tipo_usuario> lista_tip_usuario = null;
            List<Usuarios> lista_usuarios = null;
            Usuarios user = new Usuarios();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_tip_usuario = dao.getAll();
                    request.setAttribute("lista_usuarios", lista_tip_usuario);
                    request.setAttribute("usuarios", user);
                    request.getRequestDispatcher("form_usuarios.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    user = daoUsuarios.getById(id);
                    lista_tip_usuario = dao.getAll();
                    request.setAttribute("lista_usuarios", lista_tip_usuario);
                    request.setAttribute("usuarios", user);
                    request.getRequestDispatcher("form_usuarios.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    daoUsuarios.delete(id);
                    response.sendRedirect("ProcesaUsuarios");
                    break;
                /*case "lista":
                    total = daoUsuarios.total();
                    request.setAttribute("totalusuarios", total);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;*/
                case "view":
                    List<Usuarios> lista = daoUsuarios.getAll();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error fatal en ingresos" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre_apellido = request.getParameter("nombre_apellido");
        int ci = Integer.parseInt(request.getParameter("ci"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        String fecha_nac = request.getParameter("fecha_nac");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int id_user = Integer.parseInt(request.getParameter("id_user"));
        String tipo_usuario = request.getParameter("tipo_usuario");                  
        
        Usuarios user = new Usuarios();
        
        user.setId(id);
        user.setNombre_apellido(nombre_apellido);
        user.setCi(ci);
        user.setCelular(celular);
        user.setFecha_nac(fecha_nac);
        user.setEmail(email);
        user.setPassword(password);
        user.setId_user(id_user);
        user.setTipo_usuario(tipo_usuario);      
        
        if(id == 0){
            // Nuevo
            UsuariosDAO dao = new UsuariosDAOimpl();
            try {
                dao.insert(user);
                response.sendRedirect("ProcesaUsuarios");
            } catch (Exception ex) {
                System.out.println("Error usuarios"+ex.getMessage());
            }
        }
        else{
            //Editar
            UsuariosDAO dao = new UsuariosDAOimpl();
            try {
                dao.update(user);
                response.sendRedirect("ProcesaUsuarios");
            } catch (Exception ex) {
                System.out.println("Error usuarios");
            } 
    }
    }

}
