package Modelo;

/**
 * Usuario del sistema SolarTech (Administrador, Técnico o Supervisor).
 */
public class Usuario extends Persona {

    private String rol;
    private String contrasena;
    private String estado;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String correo, String rol, String contrasena, String estado) {
        super(idUsuario, nombre, correo);
        this.rol = rol;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return getIdPersona();
    }

    public void setIdUsuario(int idUsuario) {
        setIdPersona(idUsuario);
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
