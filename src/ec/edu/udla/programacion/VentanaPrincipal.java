package ec.edu.udla.programacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private final ControladorPersona controlador = new ControladorPersona();
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final JList<String> listaPersonas = new JList<>(modeloLista);

    public VentanaPrincipal() {
        setTitle("Gestión de Personas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel(new GridLayout(1, 5));
        JButton btnAgregarEst = new JButton("Agregar Estudiante");
        JButton btnAgregarProf = new JButton("Agregar Profesor");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar Personas");

        panelBotones.add(btnAgregarEst);
        panelBotones.add(btnAgregarProf);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        add(panelBotones, BorderLayout.NORTH);
        add(new JScrollPane(listaPersonas), BorderLayout.CENTER);

        btnAgregarEst.addActionListener(e -> agregarEstudiante());
        btnAgregarProf.addActionListener(e -> agregarProfesor());
        btnActualizar.addActionListener(e -> actualizarPersona());
        btnEliminar.addActionListener(e -> eliminarPersona());
        btnListar.addActionListener(e -> listarPersonas());

        setVisible(true);
    }

    private void agregarEstudiante() {
        JTextField nombre = new JTextField();
        JTextField apellido = new JTextField();
        JTextField carrera = new JTextField();
        JTextField semestre = new JTextField();
        JTextField matricula = new JTextField();

        Object[] campos = {
                "Agregar Estudiante",
                "Nombre:", nombre,
                "Apellido:", apellido,
                "Carrera:", carrera,
                "Semestre:", semestre,
                "Matrícula:", matricula
        };

        int opcion = JOptionPane.showConfirmDialog(this, campos, "Formulario Estudiante", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            Estudiante est = new Estudiante();
            est.setNombre(nombre.getText());
            est.setApellido(apellido.getText());
            est.setCarrera(carrera.getText());
            est.setSemestre(Integer.parseInt(semestre.getText()));
            est.setMatricula(Integer.parseInt(matricula.getText()));
            controlador.agregarPersona(est);
        }
    }

    private void agregarProfesor() {
        JTextField nombre = new JTextField();
        JTextField apellido = new JTextField();

        Object[] campos = {
                "Agregar Profesor",
                "Nombre:", nombre,
                "Apellido:", apellido
        };

        int opcion = JOptionPane.showConfirmDialog(this, campos, "Formulario Profesor", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            Profesor prof = new Profesor();
            prof.setNombre(nombre.getText());
            prof.setApellido(apellido.getText());
            controlador.agregarPersona(prof);
        }
    }

    private void actualizarPersona() {
        int index = listaPersonas.getSelectedIndex();
        if (index >= 0) {
            Persona p = controlador.listarPersonas().get(index);

            JTextField nombre = new JTextField(p.getNombre());
            JTextField apellido = new JTextField(p.getApellido());

            Object[] campos = {
                    "Actualizar Persona",
                    "Nombre:", nombre,
                    "Apellido:", apellido
            };

            if (p instanceof Estudiante est) {
                JTextField carrera = new JTextField(est.getCarrera());
                JTextField semestre = new JTextField(String.valueOf(est.getSemestre()));
                JTextField matricula = new JTextField(String.valueOf(est.getMatricula()));
                campos = new Object[]{
                        "Actualizar Estudiante",
                        "Nombre:", nombre,
                        "Apellido:", apellido,
                        "Carrera:", carrera,
                        "Semestre:", semestre,
                        "Matrícula:", matricula
                };

                int opcion = JOptionPane.showConfirmDialog(this, campos, "Actualizar Estudiante", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    est.setNombre(nombre.getText());
                    est.setApellido(apellido.getText());
                    est.setCarrera(carrera.getText());
                    est.setSemestre(Integer.parseInt(semestre.getText()));
                    est.setMatricula(Integer.parseInt(matricula.getText()));
                    controlador.actualizarPersona(index, est);
                }
            } else if (p instanceof Profesor prof) {
                int opcion = JOptionPane.showConfirmDialog(this, campos, "Actualizar Profesor", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    prof.setNombre(nombre.getText());
                    prof.setApellido(apellido.getText());
                    controlador.actualizarPersona(index, prof);
                }
            }
        }
    }

    private void eliminarPersona() {
        int index = listaPersonas.getSelectedIndex();
        if (index >= 0) {
            controlador.eliminarPersona(index);
        }
    }

    private void listarPersonas() {
        modeloLista.clear();
        List<Persona> personas = controlador.listarPersonas();
        for (int i = 0; i < personas.size(); i++) {
            Persona p = personas.get(i);
            modeloLista.addElement(i + ". " + p.getClass().getSimpleName());
        }
    }
}