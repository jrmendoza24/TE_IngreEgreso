package com.emergente.controlador;

import com.emergentes.DAO.Cat_egresosDAO;
import com.emergentes.DAO.Cat_egresosDAOimpl;
import com.emergentes.DAO.Cat_ingDAO;
import com.emergentes.DAO.Cat_ingDAOimpl;
import com.emergentes.DAO.EgresosDAO;
import com.emergentes.DAO.EgresosDAOimpl;
import com.emergentes.DAO.IngresosDAO;
import com.emergentes.DAO.IngresosDAOimpl;
import com.emergentes.DAO.Tipo_usuarioDAO;
import com.emergentes.DAO.Tipo_usuarioDAOimpl;
import com.emergentes.DAO.UsuariosDAO;
import com.emergentes.DAO.UsuariosDAOimpl;
import com.emergentes.modelo.Cat_egresos;
import com.emergentes.modelo.Cat_ingre;
import com.emergentes.modelo.Egresos;
import com.emergentes.modelo.Ingresos;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProcesaPaginaPrincipal", urlPatterns = {"/ProcesaPaginaPrincipal"})
public class ProcesaPaginaPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int totalingreso = 0;
            int totalegreso = 0;
            Cat_ingDAO dao = new Cat_ingDAOimpl();
            IngresosDAO daoIngresos = new IngresosDAOimpl();

            List<Cat_ingre> lista_cat_ingre = null;
            List<Ingresos> lista_ingresos = null;
            Ingresos ingresos = new Ingresos();

            Cat_egresosDAO dao2 = new Cat_egresosDAOimpl();
            EgresosDAO daoEgresos = new EgresosDAOimpl();
            List<Cat_egresos> lista_cat_egreso = null;
            List<Egresos> lista_egresos = null;
            Egresos egresos = new Egresos();
            
            /**/
            /*Tipo_usuarioDAO daos = new Tipo_usuarioDAOimpl();
            UsuariosDAO daoUsuarios = new UsuariosDAOimpl();
            List<Tipo_usuario> lista_tip_usuario = null;
            Usuarios user = new Usuarios();
            id = Integer.parseInt(request.getParameter("id"));
            user = daoUsuarios.getById(id);
            lista_tip_usuario = daos.getAll();
            request.setAttribute("lista_usuarios", lista_tip_usuario);
            request.setAttribute("usuarios", user);*/
            /**/

            totalingreso = daoIngresos.total();
            totalegreso = daoEgresos.total();
            request.setAttribute("totalingresos", totalingreso);
            request.setAttribute("totalegresos", totalegreso);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception ex) {
            System.out.println("Error fatal en ingresos" + ex.getMessage());
        }
    }
}
