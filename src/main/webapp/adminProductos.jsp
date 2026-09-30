<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("tituloPagina", "Administrar productos"); %>
<%@include file="lib/header.jsp" %>

<h2>Administraci&oacute;n de productos y servicios</h2>
<p><a class="boton acento" href="registroProductos.jsp">+ Nuevo producto / servicio</a></p>

<%-- Datos de ejemplo: la funcionalidad CRUD se implementar&aacute; en la siguiente entrega --%>
<table>
    <thead>
        <tr>
            <th>C&oacute;digo</th><th>Nombre</th><th>Tipo</th><th>Marca</th><th>Potencia (W)</th><th>Precio</th><th>Estado</th><th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>101</td><td>Panel monocristalino 550W</td><td>Panel solar</td><td>SunPower</td><td>550</td><td>$ 780.000</td><td>Disponible</td>
            <td class="acciones"><a href="#">Editar</a><a href="#">Eliminar</a></td>
        </tr>
        <tr>
            <td>102</td><td>Inversor h&iacute;brido 5kW</td><td>Inversor</td><td>Growatt</td><td>5000</td><td>$ 3.200.000</td><td>Disponible</td>
            <td class="acciones"><a href="#">Editar</a><a href="#">Eliminar</a></td>
        </tr>
        <tr>
            <td>201</td><td>Mantenimiento preventivo</td><td>Servicio de mantenimiento</td><td>SolarTech</td><td>-</td><td>$ 250.000</td><td>Disponible</td>
            <td class="acciones"><a href="#">Editar</a><a href="#">Eliminar</a></td>
        </tr>
    </tbody>
</table>

<%@include file="lib/footer.jsp" %>
