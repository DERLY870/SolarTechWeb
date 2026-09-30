<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("tituloPagina", "Administrar usuarios"); %>
<%@include file="lib/header.jsp" %>

<h2>Administraci&oacute;n de usuarios</h2>
<p><a class="boton acento" href="registroUsuarios.jsp">+ Nuevo usuario</a></p>

<%-- Datos de ejemplo: la funcionalidad CRUD se implementar&aacute; en la siguiente entrega --%>
<table>
    <thead>
        <tr>
            <th>ID</th><th>Nombre</th><th>Correo</th><th>Rol</th><th>Estado</th><th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td><td>Ana P&eacute;rez</td><td>ana@solartech.com</td><td>Administrador</td><td>Activo</td>
            <td class="acciones"><a href="#">Editar</a><a href="#">Eliminar</a></td>
        </tr>
        <tr>
            <td>2</td><td>Carlos G&oacute;mez</td><td>carlos@solartech.com</td><td>T&eacute;cnico</td><td>Activo</td>
            <td class="acciones"><a href="#">Editar</a><a href="#">Eliminar</a></td>
        </tr>
        <tr>
            <td>3</td><td>Laura Ruiz</td><td>laura@solartech.com</td><td>Supervisor</td><td>Inactivo</td>
            <td class="acciones"><a href="#">Editar</a><a href="#">Eliminar</a></td>
        </tr>
    </tbody>
</table>

<%@include file="lib/footer.jsp" %>
