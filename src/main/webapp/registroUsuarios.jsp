<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("tituloPagina", "Crear cuenta"); %>
<%@include file="lib/header.jsp" %>

<h2>Crear cuenta</h2>
<%
    String error = request.getParameter("error");
    if ("id".equals(error)) {
%>
<p style="color:#b00020; font-weight:600;">Ya existe un usuario con esa identificación.</p>
<% } else if ("correo".equals(error)) { %>
<p style="color:#b00020; font-weight:600;">Ese correo ya está registrado.</p>
<% } else if ("numero".equals(error)) { %>
<p style="color:#b00020; font-weight:600;">La identificación debe ser solo números.</p>
<% } %>

<div class="tarjeta formulario">
    <form action="RegistroServlet" method="post">
        <label for="idUsuario">Identificación</label>
        <input type="number" id="idUsuario" name="idUsuario" required>

        <label for="nombre">Nombre completo</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="correo">Correo electrónico</label>
        <input type="email" id="correo" name="correo" required>

        <label for="contrasena">Contraseña</label>
        <input type="password" id="contrasena" name="contrasena" required>

        <button type="submit" class="boton">Registrarme</button>
        <a class="boton secundario" href="login.jsp">Cancelar</a>
    </form>
</div>

<%@include file="lib/footer.jsp" %>
