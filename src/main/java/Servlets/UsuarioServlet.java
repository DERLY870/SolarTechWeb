/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
/**
 *
 * @author usuario
 */



@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    private GestionarUsuarios gestor() {
        return (GestionarUsuarios) getServletContext().getAttribute("gestionUsuarios");
    }

    // GET: listar usuarios o eliminar uno (?accion=eliminar&id=...)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("eliminar".equals(request.getParameter("accion"))) {
            try {
                gestor().eliminar(Integer.parseInt(request.getParameter("id")));
            } catch (NumberFormatException e) {
                // id inválido: no se elimina nada
            }
            response.sendRedirect("UsuarioServlet");
            return;
        }

        request.setAttribute("usuarios", gestor().listar());
        request.getRequestDispatcher("adminUsuarios.jsp").forward(request, response);
    }

    // POST: registrar un usuario nuevo
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        try {
            int id = Integer.parseInt(request.getParameter("idUsuario"));
            if (gestor().buscarPorId(id) != null) {
                response.sendRedirect("registroUsuarios.jsp"); // id repetido
                return;
            }
            Usuario u = new Usuario(
                    id,
                    request.getParameter("nombre"),
                    request.getParameter("correo"),
                    request.getParameter("rol"),
                    request.getParameter("contrasena"),
                    request.getParameter("estado"));
            gestor().agregar(u);
        } catch (NumberFormatException e) {
            response.sendRedirect("registroUsuarios.jsp");
            return;
        }
        response.sendRedirect("UsuarioServlet");
    }
}   

