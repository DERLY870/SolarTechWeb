package Servlets;

import Modelo.GestionarUsuarios;
import Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    private GestionarUsuarios gestor() {
        return (GestionarUsuarios) getServletContext().getAttribute("gestionUsuarios");
    }

    // GET: listar, eliminar (?accion=eliminar&id=...) o editar (?accion=editar&id=...)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("eliminar".equals(accion)) {
            try {
                gestor().eliminar(Integer.parseInt(request.getParameter("id")));
            } catch (NumberFormatException e) {
                // id inválido: no se elimina nada
            }
            response.sendRedirect("UsuarioServlet");
            return;
        }

        if ("editar".equals(accion)) {
            try {
                Usuario u = gestor().buscarPorId(Integer.parseInt(request.getParameter("id")));
                if (u != null) {
                    request.setAttribute("usuarioEditar", u);
                    request.getRequestDispatcher("registroUsuarios.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException e) {
                // id inválido: se vuelve a la lista
            }
            response.sendRedirect("UsuarioServlet");
            return;
        }

        request.setAttribute("usuarios", gestor().listar());
        request.getRequestDispatcher("adminUsuarios.jsp").forward(request, response);
    }

    // POST: registrar un usuario nuevo o actualizar uno existente
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        try {
            int id = Integer.parseInt(request.getParameter("idUsuario"));

            if ("actualizar".equals(request.getParameter("accion"))) {
                Usuario existente = gestor().buscarPorId(id);
                if (existente != null) {
                    String contrasena = request.getParameter("contrasena");
                    if (contrasena == null || contrasena.isEmpty()) {
                        contrasena = existente.getContrasena(); // se conserva la actual
                    }
                    gestor().actualizar(new Usuario(
                            id,
                            request.getParameter("nombre"),
                            request.getParameter("correo"),
                            request.getParameter("rol"),
                            contrasena,
                            request.getParameter("estado")));
                }
                response.sendRedirect("UsuarioServlet");
                return;
            }

            if (gestor().buscarPorId(id) != null) {
                response.sendRedirect("registroUsuarios.jsp"); // id repetido
                return;
            }
            gestor().agregar(new Usuario(
                    id,
                    request.getParameter("nombre"),
                    request.getParameter("correo"),
                    request.getParameter("rol"),
                    request.getParameter("contrasena"),
                    request.getParameter("estado")));
        } catch (NumberFormatException e) {
            response.sendRedirect("registroUsuarios.jsp");
            return;
        }
        response.sendRedirect("UsuarioServlet");
    }
}  

