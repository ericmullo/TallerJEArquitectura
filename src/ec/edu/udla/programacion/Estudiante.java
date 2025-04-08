package ec.edu.udla.programacion;

import java.util.Date;

public class Estudiante extends Persona{
    private int matricula;
    private String carrera;
    private int semestre;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public void clase() {
        System.out.println("Recibe clase");
    }

    @Override
    public void PerfilUsuario() {
        System.out.println("Perfil estudiante");
    }


}
