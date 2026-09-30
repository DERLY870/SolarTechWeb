package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio para la gestión (CRUD) de usuarios.
 * Por ahora almacena los datos en memoria; luego se conectará a una base de datos.
 */
public class GestionarUsuarios {

    private final List<Usuario> usuarios = new ArrayList<>();

    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> listar() {
        return new ArrayList<>(usuarios);
    }

    public Usuario buscarPorId(int idUsuario) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == idUsuario) {
                return u;
            }
        }
        return null;
    }

    public boolean actualizar(Usuario actualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario() == actualizado.getIdUsuario()) {
                usuarios.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int idUsuario) {
        return usuarios.removeIf(u -> u.getIdUsuario() == idUsuario);
    }
}
