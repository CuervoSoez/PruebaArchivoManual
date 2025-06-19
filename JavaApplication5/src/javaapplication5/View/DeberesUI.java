package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javaapplication5.Model.SerializationAndFileHandler;
import javaapplication5.ViewModel.Deberes;
import javaapplication5.ViewModel.Person;
import javaapplication5.ViewModel.Profesor;
import javaapplication5.ViewModel.Student;


public class DeberesUI extends JFrame {
    private JButton cambiarRolBtn;
    private JButton btnEstudiar, btnAsistir, btnInteractuar, btnEvaluar, btnGuardar;
    private JTextArea resultadoArea;
    private JTextField nombreField;
    private boolean esProfesor = false;

    private Profesor profesor;
    private Student estudiante;

    private final String ARCHIVO_ACCIONES = "acciones.txt";

    public DeberesUI() {
        profesor = new Profesor("Dr. Ruiz", 50, "Calle 1");
        estudiante = new Student("Estudiante Sin Nombre", 20, "Cra 10");

        setTitle("Deberes");
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        cambiarRolBtn = new JButton("Cambiar a Profesor");
        nombreField = new JTextField("Nombre del Estudiante");
        topPanel.add(nombreField, BorderLayout.CENTER);
        topPanel.add(cambiarRolBtn, BorderLayout.EAST);

        cambiarRolBtn.addActionListener(e -> {
            guardarNombre();
            esProfesor = !esProfesor;
            String nuevoNombre = esProfesor ? profesor.getName() : estudiante.getName();
            nombreField.setText(nuevoNombre);
            cambiarRolBtn.setText(esProfesor ? "Cambiar a Estudiante" : "Cambiar a Profesor");
            resultadoArea.setText("Rol cambiado a " + (esProfesor ? "Profesor" : "Estudiante"));
        });

        JPanel botonesPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        btnEstudiar = new JButton("Estudiar");
        btnAsistir = new JButton("Asistir a Clase");
        btnInteractuar = new JButton("Interactuar");
        btnEvaluar = new JButton("Evaluar");
        btnGuardar = new JButton("Guardar Persona");

        botonesPanel.add(btnEstudiar);
        botonesPanel.add(btnAsistir);
        botonesPanel.add(btnInteractuar);
        botonesPanel.add(btnEvaluar);
        botonesPanel.add(btnGuardar);

        resultadoArea = new JTextArea(6, 20);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        btnEstudiar.addActionListener(e -> ejecutarAccion(p -> p.estudiar()));
        btnAsistir.addActionListener(e -> ejecutarAccion(p -> p.asistirClase()));
        btnInteractuar.addActionListener(e -> ejecutarAccion(p -> p.interactuar()));
        btnEvaluar.addActionListener(e -> ejecutarAccion(p -> p.evaluar()));
        btnGuardar.addActionListener(e -> guardarPersona());

        add(topPanel, BorderLayout.NORTH);
        add(botonesPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void ejecutarAccion(AccionDeber accion) {
        guardarNombre();
        Deberes persona = esProfesor ? profesor : estudiante;
        String mensaje = capturarSalida(() -> accion.ejecutar(persona));
        resultadoArea.setText(mensaje);
        guardarEnArchivo(mensaje);
    }

    private void guardarNombre() {
        String nombre = nombreField.getText().trim();
        if (!nombre.isEmpty()) {
            if (esProfesor) {
                profesor.setName(nombre);
            } else {
                estudiante.setName(nombre);
            }
        }
    }

    private void guardarPersona() {
        guardarNombre();
        List<Person> personas = new ArrayList<>();
        personas.add(esProfesor ? profesor : estudiante);
        SerializationAndFileHandler.guardarPersonas(personas);
        JOptionPane.showMessageDialog(this, "✅ Persona guardada en .ser y .txt correctamente.");
    }

    private String capturarSalida(Runnable metodo) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        metodo.run();
        System.out.flush();
        System.setOut(old);
        return baos.toString();
    }

    private void guardarEnArchivo(String texto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_ACCIONES, true))) {
            writer.write(texto.trim());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar en archivo: " + e.getMessage());
        }
    }

    private interface AccionDeber {
        void ejecutar(Deberes persona);
    }
}