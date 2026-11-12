/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author usuario
 */
package Servlets;

import Modelo.GestionarUsuarios;
import Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        GestionarUsuarios gestor = (GestionarUsuarios) getServletContext().getAttribute("gestionUsuarios");

        try {
            int id = Integer.parseInt(request.getParameter("idUsuario"));
            String correo = request.getParameter("correo").trim();

            if (gestor.buscarPorId(id) != null) {
                response.sendRedirect("registroUsuarios.jsp?error=id");
                return;
            }
            if (gestor.existeCorreo(correo)) {
                response.sendRedirect("registroUsuarios.jsp?error=correo");
                return;
            }

            gestor.agregar(new Usuario(
                    id,
                    request.getParameter("nombre").trim(),
                    correo,
                    "Usuario",
                    request.getParameter("contrasena"),
                    "Activo"));

        } catch (NumberFormatException e) {
            response.sendRedirect("registroUsuarios.jsp?error=numero");
            return;
        }
        response.sendRedirect("login.jsp?registrado=1");
    }
}

