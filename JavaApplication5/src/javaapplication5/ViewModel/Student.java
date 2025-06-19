package javaapplication5.ViewModel;

import javaapplication5.ViewModel.Person;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Student extends Person {
    public Student(String name, int age, String address) {
        super(name, age, address);
    }

    @Override
    public void interactuar() {
        System.out.println(getName() + " levantó la mano para hacer una pregunta-");
    }

    @Override
    public void evaluar() {
        System.out.println(getName() + " está haciendo la encuesta docente");
    }
    @Override
    public void estudiar() {
        System.out.println(getName() + " está estudiando los temas para el sigueinte parcial") ;
    }
    @Override
    public void asistirClase () {
        System.out.println(getName() + " llegó a tiempo y se sentó a tomar notas");
    }
}

    
