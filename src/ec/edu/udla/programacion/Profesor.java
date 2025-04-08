package ec.edu.udla.programacion;

public class Profesor extends Persona implements Usuario {
    @Override
    public void clase() {
        System.out.println("Impartir clase");
    }

    @Override
    public void Iniciarsesion() {

    }
}
