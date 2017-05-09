/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.GetMeal;

/**
 *
 * @author kari
 */
public class AddMealListener implements ActionListener {
    private GetMeal getMeal;
    private Container parent;
    
    public AddMealListener(Container parent, GetMeal getMeal) {
        this.getMeal = getMeal;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String meal = (String)JOptionPane.showInputDialog(parent, "Syötä uuden ruoan nimi", "Lisää ruoka", JOptionPane.PLAIN_MESSAGE);
        if (!meal.isEmpty()) {
            try {
                getMeal.addMeal(meal);
            } catch (IOException ex) {
                Logger.getLogger(AddMealListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
