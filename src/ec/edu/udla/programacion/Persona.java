package ec.edu.udla.programacion;

import java.util.Date;

public abstract class Persona implements Usuario {
    private String nombre;
    private String Apellido;
    private Date bday;
    private String genero;
    private int id;

    public Persona(String nombre, String apellido, Date bday, String genero, int id) {
        this.nombre = nombre;
        Apellido = apellido;
        this.bday = bday;
        this.genero = genero;
        this.id = id;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void caminar(){
        System.out.println("Persona Caminar");
    }
    public abstract void clase();

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", bday=" + bday +
                ", genero='" + genero + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public void Iniciarsesion() {
        System.out.println("Inicio de sesion");
    }

    @Override
    public abstract void PerfilUsuario();
}
