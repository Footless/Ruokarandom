/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruokarandom;

import gui.GUI;
import java.io.IOException;
import javax.swing.SwingUtilities;
import ui.Prompt;

/**
 *
 * @author kari
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        Prompt prompt = new Prompt();
//        prompt.start();
        GUI gui = new GUI();
        SwingUtilities.invokeLater(gui);
    }
    
}
