package ec.edu.udla.programacion;

public class Profesor extends Persona {
    @Override
    public void clase() {
        System.out.println("Impartir clase");
    }

    @Override
    public void Iniciarsesion() {
        System.out.println("Profesor inicia sesión");
    }

    @Override
    public void PerfilUsuario() {
        System.out.println("Perfil profesor");
    }

    @Override
    public String toString() {
        return "Profesor";
    }
}
