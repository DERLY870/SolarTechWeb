<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("tituloPagina", "Ingreso"); %>
<%@include file="lib/header.jsp" %>

<h2>Ingreso a la aplicaci&oacute;n</h2>
<div class="tarjeta formulario">
    <form action="#" method="post">
        <label for="correo">Correo electr&oacute;nico</label>
        <input type="email" id="correo" name="correo" placeholder="usuario@solartech.com" required>

        <label for="contrasena">Contrase&ntilde;a</label>
        <input type="password" id="contrasena" name="contrasena" required>

        <button type="submit" class="boton">Ingresar</button>
        <a class="boton secundario" href="registroUsuarios.jsp">Crear cuenta</a>
    </form>
</div>

<%@include file="lib/footer.jsp" %>
