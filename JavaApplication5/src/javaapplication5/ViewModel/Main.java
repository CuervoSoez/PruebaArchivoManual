/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5.ViewModel;

/**
 *
 * @author user
 */

import View.DeberesUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DeberesUI ventana = new DeberesUI();
            ventana.setVisible(true);
        });
    }
}
    
