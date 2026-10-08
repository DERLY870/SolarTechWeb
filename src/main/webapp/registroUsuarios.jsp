<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("tituloPagina", "Registro de usuarios"); %>
<%@include file="lib/header.jsp" %>

<h2>Registrar nuevo usuario</h2>
<div class="tarjeta formulario">
    <form action="UsuarioServlet" method="post"></form>
        <label for="idUsuario">Identificaci&oacute;n</label>
        <input type="number" id="idUsuario" name="idUsuario" required>

        <label for="nombre">Nombre completo</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="correo">Correo electr&oacute;nico</label>
        <input type="email" id="correo" name="correo" required>

        <label for="rol">Rol</label>
        <select id="rol" name="rol" required>
            <option value="">Seleccione...</option>
            <option>Administrador</option>
            <option>T&eacute;cnico</option>
            <option>Supervisor</option>
        </select>

        <label for="contrasena">Contrase&ntilde;a</label>
        <input type="password" id="contrasena" name="contrasena" required>

        <label for="estado">Estado</label>
        <select id="estado" name="estado">
            <option>Activo</option>
            <option>Inactivo</option>
        </select>

        <button type="submit" class="boton">Registrar</button>
        <a class="boton secundario" href="adminUsuarios.jsp">Cancelar</a>
    </form>
</div>

<%@include file="lib/footer.jsp" %>
