package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio para la gestión (CRUD) de productos / servicios.
 * Por ahora almacena los datos en memoria; luego se conectará a una base de datos.
 */
public class GestionarProductos {

    private final List<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }

    public Producto buscarPorId(int idProducto) {
        for (Producto p : productos) {
            if (p.getIdProducto() == idProducto) {
                return p;
            }
        }
        return null;
    }

    public boolean actualizar(Producto actualizado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getIdProducto() == actualizado.getIdProducto()) {
                productos.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int idProducto) {
        return productos.removeIf(p -> p.getIdProducto() == idProducto);
    }
}
