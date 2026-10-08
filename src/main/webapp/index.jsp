<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("tituloPagina", "Inicio"); %>
<%@include file="lib/header.jsp" %>

<h2>Bienvenido a SolarTech</h2>
<div class="tarjeta">
    <p>
        <strong>SolarTech</strong> es un sistema de informaci&oacute;n para administrar instalaciones
        fotovoltaicas: control de paneles solares, registro de la producci&oacute;n de energ&iacute;a,
        mantenimientos y reportes de eficiencia.
    </p>
    <p>
        El objetivo es centralizar la informaci&oacute;n de las instalaciones, reducir fallas por falta
        de seguimiento y apoyar la toma de decisiones con datos confiables.
    </p>
</div>

<div class="tarjetas">
    <div class="tarjeta">
        <h3>Usuarios</h3>
        <p>Administraci&oacute;n de administradores, t&eacute;cnicos y supervisores del sistema.</p>
        <a class="boton" href="UsuarioServlet">Ver usuarios</a>
    </div>
    <div class="tarjeta">
        <h3>Productos y servicios</h3>
        <p>Cat&aacute;logo de paneles, inversores y servicios de instalaci&oacute;n y mantenimiento.</p>
        <a class="boton" href="ProductoServlet">Ver productos</a>
    </div>
    <div class="tarjeta">
        <h3>Acceso</h3>
        <p>Ingresa con tu correo y contrase&ntilde;a para usar la aplicaci&oacute;n.</p>
        <a class="boton acento" href="login.jsp">Ingresar</a>
    </div>
</div>

<%@include file="lib/footer.jsp" %>
