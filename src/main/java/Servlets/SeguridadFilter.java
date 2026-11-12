/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

/**
 *
 * @author Cordoba Diaz
 */

import Modelo.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class SeguridadFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String ruta = request.getServletPath();

        // 1. Rutas públicas
        boolean esRutaPublica = ruta.endsWith("login.jsp")
        || ruta.endsWith("LoginServlet")
        || ruta.endsWith("registroUsuarios.jsp")
        || ruta.endsWith("RegistroServlet")
        || ruta.contains("/styles/")
        || ruta.contains("/images/")
        || ruta.contains("/scripts/");
        if (esRutaPublica) {
            chain.doFilter(req, res);
            return;
        }

        // 2. Debe haber iniciado sesión
        HttpSession sesion = request.getSession(false);
        Usuario u = (sesion == null) ? null : (Usuario) sesion.getAttribute("usuarioLogueado");
        if (u == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // 3. Solo el administrador puede modificar datos
        String accion = request.getParameter("accion");
        boolean modifica = "POST".equals(request.getMethod())
                || "eliminar".equals(accion) || "editar".equals(accion)
                || ruta.equals("/registroUsuarios.jsp") || ruta.equals("/registroProductos.jsp");

        if (modifica && !"Administrador".equals(u.getRol())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN,
                    "Solo el administrador puede modificar datos");
            return;
        }

        chain.doFilter(req, res);
    }
}

