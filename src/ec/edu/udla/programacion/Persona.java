package ec.edu.udla.programacion;

import java.io.Serializable;
import java.util.Date;

public abstract class Persona implements Usuario, Serializable {
    private String nombre;
    private String apellido;
    private Date bday;
    private String genero;
    private int id;

    public Persona(String nombre, String apellido, Date bday, String genero, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.bday = bday;
        this.genero = genero;
        this.id = id;
    }

    public Persona() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public Date getBday() { return bday; }
    public void setBday(Date bday) { this.bday = bday; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public void caminar() {
        System.out.println("Persona Caminar");
    }

    public abstract void clase();

    @Override
    public void Iniciarsesion() {
        System.out.println("Inicio de sesion");
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
