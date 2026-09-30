<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("tituloPagina", "Registro de productos"); %>
<%@include file="lib/header.jsp" %>

<h2>Registrar producto / servicio</h2>
<div class="tarjeta formulario">
    <form action="#" method="post">
        <label for="idProducto">C&oacute;digo</label>
        <input type="number" id="idProducto" name="idProducto" required>

        <label for="nombre">Nombre</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="tipo">Tipo</label>
        <select id="tipo" name="tipo" required>
            <option value="">Seleccione...</option>
            <option>Panel solar</option>
            <option>Inversor</option>
            <option>Bater&iacute;a</option>
            <option>Servicio de instalaci&oacute;n</option>
            <option>Servicio de mantenimiento</option>
        </select>

        <label for="marca">Marca</label>
        <input type="text" id="marca" name="marca">

        <label for="modelo">Modelo</label>
        <input type="text" id="modelo" name="modelo">

        <label for="potencia">Potencia (W)</label>
        <input type="number" step="0.01" id="potencia" name="potencia">

        <label for="precio">Precio (COP)</label>
        <input type="number" step="0.01" id="precio" name="precio" required>

        <label for="estado">Estado</label>
        <select id="estado" name="estado">
            <option>Disponible</option>
            <option>Agotado</option>
            <option>Descontinuado</option>
        </select>

        <button type="submit" class="boton">Registrar</button>
        <a class="boton secundario" href="adminProductos.jsp">Cancelar</a>
    </form>
</div>

<%@include file="lib/footer.jsp" %>
