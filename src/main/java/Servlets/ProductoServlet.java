/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import Modelo.GestionarProductos;
import Modelo.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    private GestionarProductos gestor() {
        return (GestionarProductos) getServletContext().getAttribute("gestionProductos");
    }

    // GET: listar productos o eliminar uno (?accion=eliminar&id=...)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("eliminar".equals(request.getParameter("accion"))) {
            try {
                gestor().eliminar(Integer.parseInt(request.getParameter("id")));
            } catch (NumberFormatException e) {
                // id inválido: no se elimina nada
            }
            response.sendRedirect("ProductoServlet");
            return;
        }

        request.setAttribute("productos", gestor().listar());
        request.getRequestDispatcher("adminProductos.jsp").forward(request, response);
    }

    // POST: registrar un producto o servicio nuevo
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        try {
            int id = Integer.parseInt(request.getParameter("idProducto"));
            if (gestor().buscarPorId(id) != null) {
                response.sendRedirect("registroProductos.jsp?error=duplicado");
                return;
            }

            // La potencia es opcional (los servicios no tienen potencia)
            String textoPotencia = request.getParameter("potencia");
            double potencia = 0;
            if (textoPotencia != null && !textoPotencia.isEmpty()) {
                potencia = Double.parseDouble(textoPotencia);
            }
            double precio = Double.parseDouble(request.getParameter("precio"));

            Producto p = new Producto(
                    id,
                    request.getParameter("nombre"),
                    request.getParameter("tipo"),
                    request.getParameter("marca"),
                    request.getParameter("modelo"),
                    potencia,
                    precio,
                    request.getParameter("estado"));
            gestor().agregar(p);
        } catch (NumberFormatException e) {
            response.sendRedirect("registroProductos.jsp?error=numero");
            return;
        }
        response.sendRedirect("ProductoServlet");
    }
}

