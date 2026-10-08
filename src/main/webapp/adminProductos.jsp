<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    if (productos == null) {
        response.sendRedirect("ProductoServlet");
        return;
    }
%>
<% request.setAttribute("tituloPagina", "Administrar productos"); %>
<%@include file="lib/header.jsp" %>

<h2>Administración de productos y servicios</h2>
<p><a class="boton acento" href="registroProductos.jsp">+ Nuevo producto / servicio</a></p>

<table>
    <thead>
        <tr>
            <th>Código</th><th>Nombre</th><th>Tipo</th><th>Marca</th>
            <th>Potencia (W)</th><th>Precio</th><th>Estado</th><th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <% for (Producto p : productos) { %>
        <tr>
            <td><%= p.getIdProducto() %></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getTipo() %></td>
            <td><%= p.getMarca() %></td>
            <td><%= p.getPotencia() > 0 ? String.format("%.0f", p.getPotencia()) : "-" %></td>
            <td>$ <%= String.format("%,.0f", p.getPrecio()) %></td>
            <td><%= p.getEstado() %></td>
            <td class="acciones">
                <a href="ProductoServlet?accion=eliminar&id=<%= p.getIdProducto() %>"
                   data-confirmar="¿Eliminar este producto?">Eliminar</a>
            </td>
        </tr>
        <% } %>
    </tbody>
</table>

<%@include file="lib/footer.jsp" %>