package ec.edu.udla.programacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorPersona {
    private static final String ARCHIVO = "personas.ser";
    private List<Persona> personas;

    public ControladorPersona() {
        personas = cargar();
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
        guardar();
    }

    public List<Persona> listarPersonas() {
        return personas;
    }

    public void actualizarPersona(int index, Persona nueva) {
        if (index >= 0 && index < personas.size()) {
            personas.set(index, nueva);
            guardar();
        }
    }

    public void eliminarPersona(int index) {
        if (index >= 0 && index < personas.size()) {
            personas.remove(index);
            guardar();
        }
    }

    private void guardar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(personas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Persona> cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (List<Persona>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
