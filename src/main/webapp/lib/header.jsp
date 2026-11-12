<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuarioSesion = (Usuario) session.getAttribute("usuarioLogueado");
    boolean logueado = (usuarioSesion != null);
    boolean esAdmin = logueado && "Administrador".equalsIgnoreCase(usuarioSesion.getRol());

    String tituloPagina = (String) request.getAttribute("tituloPagina");
    if (tituloPagina == null) {
        tituloPagina = "SolarTech";
    }
    String ctx = request.getContextPath();
    String paginaActual = request.getRequestURI();
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SolarTech | <%= tituloPagina%></title>
        <link rel="stylesheet" href="<%= ctx%>/styles/style.css?v=4">
    </head>
    <body>
        <header>
            <div class="contenedor-header" style="max-width: 1100px; margin: 0 auto; display: flex; justify-content: space-between; align-items: center; flex-wrap: wrap; gap: 1rem;">
                <a href="<%= ctx%>/index.jsp" style="font-size: 1.3rem; font-weight: 700; color: #f59e0b; margin: 0;">
                    ☀ SolarTech
                </a>
                <nav style="background: none; box-shadow: none; padding: 0;">
                    <a href="<%= ctx%>/index.jsp">Inicio</a>
                    <% if (!logueado) { %>
                        <% if (!paginaActual.endsWith("login.jsp") && !paginaActual.endsWith("index.jsp") && !paginaActual.endsWith("/SolarTechWeb/")) { %>
                            <a href="<%= ctx%>/login.jsp">Ingresar</a>
                        <% } %>
                    <% } else { %>
                        <a href="<%= ctx%>/UsuarioServlet">Usuarios</a>
                        <a href="<%= ctx%>/ProductoServlet">Productos</a>
                        <% if (esAdmin) { %>
                            <a href="<%= ctx%>/registroUsuarios.jsp">Nuevo usuario</a>
                            <a href="<%= ctx%>/registroProductos.jsp">Nuevo producto</a>
                        <% } %>
                        <a href="<%= ctx%>/LoginServlet">Salir (<%= usuarioSesion.getNombre()%>)</a>
                    <% } %>
                </nav>
            </div>
        </header>
        <main>