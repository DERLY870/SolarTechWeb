package Modelo;

/**
 * Clase base para las personas que interactúan con SolarTech.
 */
public class Persona {

    private int idPersona;
    private String nombre;
    private String correo;

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String correo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
