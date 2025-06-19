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
public class Profesor extends Person {
    public Profesor(
            String name, 
            int age, 
            String address) {
        super(name, age, address);
    }

    @Override
    public void interactuar() {
        System.out.println(getName() + " hizo una pregunta por un punto");
    }

    @Override
    public void evaluar() {
        System.out.println(getName() + " está poniendo notas a los estudiantes en el SIA");
    }
    
    @Override
    public void estudiar() {
        System.out.println(getName() + " esté estudiando el tema que dictará la siguiente clase y preparando la presentación");
    }
    @Override
    public void asistirClase () {
        System.out.println(getName() + " está en clase dictando el tema");
    }
}
    
