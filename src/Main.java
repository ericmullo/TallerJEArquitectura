import ec.edu.udla.programacion.Estudiante;
import ec.edu.udla.programacion.Persona;
import ec.edu.udla.programacion.Profesor;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
      Persona p = new Estudiante();
        p.setNombre("Eric");
      Persona antonio = new Profesor();
      p.setNombre("Josue");
      System.out.println(p.getNombre());
      System.out.println(antonio.getNombre());
      p.clase();
      antonio.clase();

    }
}