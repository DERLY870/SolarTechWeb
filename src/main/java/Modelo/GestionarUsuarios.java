package Modelo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GestionarUsuarios {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final String rutaArchivo;

    // Constructor por defecto (guarda en la carpeta de ejecución del servidor)
    public GestionarUsuarios() {
        this("usuarios.txt");
    }

    // Constructor con ruta específica (ideal si pasas getServletContext().getRealPath("/WEB-INF/usuarios.txt"))
    public GestionarUsuarios(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        cargarDesdeArchivo();
    }

    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
        guardarEnArchivo();
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
                guardarEnArchivo();
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int idUsuario) {
        boolean eliminado = usuarios.removeIf(u -> u.getIdUsuario() == idUsuario);
        if (eliminado) {
            guardarEnArchivo();
        }
        return eliminado;
    }

    public Usuario autenticar(String correo, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo)
                    && u.getContrasena().equals(contrasena)
                    && "Activo".equals(u.getEstado())) {
                return u;
            }
        }
        return null;
    }

    public boolean existeCorreo(String correo) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }

    private void guardarEnArchivo() {
        File archivo = new File(rutaArchivo);
        if (archivo.getParentFile() != null) {
            archivo.getParentFile().mkdirs();
        }
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(archivo), StandardCharsets.UTF_8))) {
            for (Usuario u : usuarios) {
                bw.write(u.getIdUsuario() + ";"
                        + u.getNombre() + ";"
                        + u.getCorreo() + ";"
                        + u.getRol() + ";"
                        + u.getContrasena() + ";"
                        + u.getEstado());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarDesdeArchivo() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return;
        }
        usuarios.clear();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 6) {
                    usuarios.add(new Usuario(
                            Integer.parseInt(datos[0]),
                            datos[1],
                            datos[2],
                            datos[3],
                            datos[4],
                            datos[5]
                    ));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
