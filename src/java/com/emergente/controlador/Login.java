package com.emergente.controlador;

import com.emergentes.conexion.Validacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int id;
        int iduser;
        System.out.println("Datos.. " + email + " " + password);

        Validacion v = new Validacion();

        if (v.checkUser(email, password)) {
            iduser = v.id_user(email, password);
            id = v.id(email, password);
            System.out.println("id usuario" + iduser);
            HttpSession ses = request.getSession();
            ses.setAttribute("login", "OK");
            ses.setAttribute("id", id);
            ses.setAttribute("iduser", iduser);
            if(iduser == 1){
                ses.setAttribute("id_user", "1");
            }else{
                ses.setAttribute("id_user", "0");
            }
            response.sendRedirect("ProcesaPaginaPrincipal");
            
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
