package javaapplication5.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import javaapplication5.ViewModel.Person;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que demuestra el uso de Serializable y operaciones con archivos
 */
public class SerializationAndFileHandler {

    public static final String SERIALIZED_FILE = "personas.ser";
    public static final String TEXT_FILE = "personas.txt";
    public static final String DESERIALIZED_TXT = "personas_deserializadas.txt";

    public static void guardarPersonas(List<Person> personas) {
        try {
            serializeObjects(personas, SERIALIZED_FILE);
            writeToFile(personas, TEXT_FILE);
            crearTxtDesdeSerializable(SERIALIZED_FILE, DESERIALIZED_TXT);
            System.out.println("✅ Personas guardadas correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serializeObjects(List<Person> people, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
        }
    }

    private static void writeToFile(List<Person> people, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Person person : people) {
                writer.write(person.toString());
                writer.newLine();
            }
        }
    }

    private static List<Person> deserializeObjects(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Person>) ois.readObject();
        }
    }

    private static void crearTxtDesdeSerializable(String archivoSer, String archivoTxt) throws IOException, ClassNotFoundException {
        List<Person> personas = deserializeObjects(archivoSer);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTxt))) {
            for (Person p : personas) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
    }
}