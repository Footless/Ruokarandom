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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logic.GetMeal;

/**
 *
 * @author kari
 */
public class GetMealListener implements ActionListener {

    private final GetMeal getMeal;
    private final Container parent;
    private final JFrame frame;

    public GetMealListener(JFrame frame, GetMeal getMeal, Container parent) {
        this.getMeal = getMeal;
        this.parent = parent;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object[] options = {"Kyllä", "Ei"};
        while (true) {
            String meal = getMeal.getRandonMeal();
            int n = JOptionPane.showOptionDialog(parent, meal, "Ruoka", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                try {
                    getMeal.addToHistory(meal);
                } catch (IOException ex) {
                    Logger.getLogger(GetMealListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(parent, "Hienoa! Tänään on ruokana " + meal);
                break;
            } 
        }
        frame.dispose();
    }

}
