/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;
import Modelo.GestionarProductos;
import Modelo.GestionarUsuarios;
import Modelo.Usuario;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 *
 * @author usuario
 */

@WebListener
public class Inicializador implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        GestionarUsuarios usuarios = new GestionarUsuarios();

        // Usuario administrador inicial
        if (usuarios.buscarPorId(1) == null) {
            usuarios.agregar(new Usuario(1, "Administrador", "admin@solartech.com",
                    "Administrador", "admin123", "Activo"));
        }

        // Usuario inicial para poder probar el login
        if (usuarios.buscarPorId(2) == null) {
            usuarios.agregar(new Usuario(2, "Técnico Demo", "tecnico@solartech.com",
                    "Técnico", "tec123", "Activo"));
        }

        sce.getServletContext().setAttribute("gestionUsuarios", usuarios);
        sce.getServletContext().setAttribute("gestionProductos", new GestionarProductos());
    }
}

