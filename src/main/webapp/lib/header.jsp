<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String tituloPagina = (String) request.getAttribute("tituloPagina");
    if (tituloPagina == null) {
        tituloPagina = "SolarTech";
    }
    String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SolarTech | <%= tituloPagina%></title>
        <link rel="stylesheet" href="<%= ctx%>/styles/style.css">
    </head>
    <body>





    </nav>
    <header>
        <img class="banner" src="<%= ctx%>/images/banner.jpg" alt="Banner SolarTech">
        <div class="barra">
            <h1>SolarTech</h1>
            <nav>
                <a href="<%= ctx%>/index.jsp">Inicio</a>
                <a href="<%= ctx%>/login.jsp">Ingresar</a>
                <a href="<%= ctx %>/UsuarioServlet">Usuarios</a>
                <a href="<%= ctx%>/registroUsuarios.jsp">Nuevo usuario</a>
                <a href="<%= ctx%>/ProductoServlet">Productos</a>
                <a href="<%= ctx%>/registroProductos.jsp">Nuevo producto</a>
            </nav>
        </div>
    </header>
    <main>
