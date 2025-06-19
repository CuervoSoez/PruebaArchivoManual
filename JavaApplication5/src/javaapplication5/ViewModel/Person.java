package javaapplication5.ViewModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javaapplication5.ViewModel.Deberes;
import java.io.Serializable;

/**
 * Clase Person que implementa la interfaz Serializable
 * Esta clase demuestra cómo hacer que un objeto sea serializable en Java
 */
public class Person implements Serializable, Deberes {
    private static final long serialVersionUID = 1L;
    
    String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Getters y setters omitidos por brevedad

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    // Métodos de Deberes con implementación genérica
    @Override
    public void estudiar() {
        System.out.println(name + " está estudiando.");
    }

    @Override
    public void asistirClase() {
        System.out.println(name + " está asistiendo a clase.");
    }

    @Override
    public void interactuar() {
        System.out.println(name + " está interactuando.");
    }

    public String getName() {
        return name;
    }

    @Override
    public void evaluar() {
        System.out.println(name + " está participando en evaluaciones.");
    
        
        
    }  

    public void setName(String name) {
        this.name = name;
    }
}