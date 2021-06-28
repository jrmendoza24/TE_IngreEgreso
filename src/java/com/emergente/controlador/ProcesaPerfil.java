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

@WebServlet(name = "ProcesaPerfil", urlPatterns = {"/ProcesaPerfil"})
public class ProcesaPerfil extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Tipo_usuarioDAO dao = new Tipo_usuarioDAOimpl();
            UsuariosDAO daoUsuarios = new UsuariosDAOimpl();
            int id;
            List<Tipo_usuario> lista_tip_usuario = null;
            Usuarios user = new Usuarios();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    user = daoUsuarios.getById(id);
                    lista_tip_usuario = dao.getAll();
                    request.setAttribute("lista_usuarios", lista_tip_usuario);
                    request.setAttribute("usuarios", user);
                    request.getRequestDispatcher("form_usuarios.jsp").forward(request, response);
                    break;
                case "view":
                    id = Integer.parseInt(request.getParameter("id"));
                    user = daoUsuarios.getById(id);
                    lista_tip_usuario = dao.getAll();
                    request.setAttribute("lista_usuarios", lista_tip_usuario);
                    request.setAttribute("usuarios", user);
                    request.getRequestDispatcher("perfil.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error fatal en ingresos" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
