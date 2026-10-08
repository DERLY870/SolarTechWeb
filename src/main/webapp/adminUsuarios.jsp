<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<%
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
    if (usuarios == null) {
        response.sendRedirect("UsuarioServlet");
        return;
    }
%>
<% request.setAttribute("tituloPagina", "Administrar usuarios");%>
<%@include file="lib/header.jsp" %>

<h2>Administración de usuarios</h2>
<p><a class="boton acento" href="registroUsuarios.jsp">+ Nuevo usuario</a></p>

<table>
    <thead>
        <tr>
            <th>ID</th><th>Nombre</th><th>Correo</th><th>Rol</th><th>Estado</th><th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <% for (Usuario u : usuarios) {%>
        <tr>
            <td><%= u.getIdUsuario()%></td>
            <td><%= u.getNombre()%></td>
            <td><%= u.getCorreo()%></td>
            <td><%= u.getRol()%></td>
            <td><%= u.getEstado()%></td>
            <td class="acciones">
                <a href="UsuarioServlet?accion=eliminar&id=<%= u.getIdUsuario()%>"
                   data-confirmar="¿Eliminar este usuario?">Eliminar</a>
            </td>
        </tr>
        <% }%>
    </tbody>
</table>

<%@include file="lib/footer.jsp" %>