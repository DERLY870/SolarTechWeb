/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    package Servlets;

import Modelo.GestionarUsuarios;
import Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    // GET: cerrar sesión
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            sesion.invalidate();
        }
        response.sendRedirect("login.jsp");
    }

    // POST: iniciar sesión
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        GestionarUsuarios gestor = (GestionarUsuarios) getServletContext().getAttribute("gestionUsuarios");

        Usuario u = gestor.autenticar(request.getParameter("correo"), request.getParameter("contrasena"));
        if (u == null) {
            response.sendRedirect("login.jsp?error=1");
            return;
        }

        HttpSession vieja = request.getSession(false);
        if (vieja != null) {
            vieja.invalidate();
        }
        request.getSession(true).setAttribute("usuarioLogueado", u);
        response.sendRedirect("index.jsp");
    }
}

