/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import View.DeberesUI;
import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class LanzadorGrafico {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DeberesUI ventana = new DeberesUI();
            ventana.setVisible(true);
        });
    }
}