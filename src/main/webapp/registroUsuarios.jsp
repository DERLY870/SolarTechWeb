<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuario"%>
<%
    Usuario editar = (Usuario) request.getAttribute("usuarioEditar");
    boolean modoEditar = (editar != null);
    request.setAttribute("tituloPagina", modoEditar ? "Editar usuario" : "Registro de usuarios");
%>
<%@include file="lib/header.jsp" %>

<h2><%= modoEditar ? "Editar usuario" : "Registrar nuevo usuario" %></h2>
<div class="tarjeta formulario">
    <form action="UsuarioServlet" method="post">
        <% if (modoEditar) { %>
        <input type="hidden" name="accion" value="actualizar">
        <% } %>

        <label for="idUsuario">Identificación</label>
        <input type="number" id="idUsuario" name="idUsuario"
               value="<%= modoEditar ? editar.getIdUsuario() : "" %>"
               <%= modoEditar ? "readonly" : "" %> required>

        <label for="nombre">Nombre completo</label>
        <input type="text" id="nombre" name="nombre"
               value="<%= modoEditar ? editar.getNombre() : "" %>" required>

        <label for="correo">Correo electrónico</label>
        <input type="email" id="correo" name="correo"
               value="<%= modoEditar ? editar.getCorreo() : "" %>" required>

        <label for="rol">Rol</label>
        <select id="rol" name="rol" required>
            <option value="">Seleccione...</option>
            <option <%= modoEditar && "Administrador".equals(editar.getRol()) ? "selected" : "" %>>Administrador</option>
            <option <%= modoEditar && "Técnico".equals(editar.getRol()) ? "selected" : "" %>>Técnico</option>
            <option <%= modoEditar && "Supervisor".equals(editar.getRol()) ? "selected" : "" %>>Supervisor</option>
        </select>

        <label for="contrasena">Contraseña<%= modoEditar ? " (déjala vacía para conservar la actual)" : "" %></label>
        <input type="password" id="contrasena" name="contrasena" <%= modoEditar ? "" : "required" %>>

        <label for="estado">Estado</label>
        <select id="estado" name="estado">
            <option <%= modoEditar && "Activo".equals(editar.getEstado()) ? "selected" : "" %>>Activo</option>
            <option <%= modoEditar && "Inactivo".equals(editar.getEstado()) ? "selected" : "" %>>Inactivo</option>
        </select>

        <button type="submit" class="boton"><%= modoEditar ? "Guardar cambios" : "Registrar" %></button>
        <a class="boton secundario" href="UsuarioServlet">Cancelar</a>
    </form>
</div>

<%@include file="lib/footer.jsp" %>
