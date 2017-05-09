/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import logic.GetMeal;

/**
 *
 * @author kari
 */
public class GUI implements Runnable {
    
    private JFrame frame;
    GetMeal getMeal;

    @Override
    public void run() {
        try {
            getMeal = new GetMeal();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame = new JFrame("Ruoan arpoja");
        frame.setPreferredSize(new Dimension(400,300));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);
        JMenuItem addMealItem = new JMenuItem("Lisää uusi ruoka", KeyEvent.VK_L);
        AddMealListener addMealListener = new AddMealListener(frame,getMeal);
        addMealItem.addActionListener(addMealListener);
        fileMenu.add(addMealItem);
        frame.setJMenuBar(menuBar);
        
        makeComponents(frame.getContentPane());
        
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private void makeComponents(Container contentPane) {
        JButton getMealButton = new JButton("Arvo ruoka");
        GetMealListener getMealListener = new GetMealListener(frame, getMeal, contentPane);
        getMealButton.addActionListener(getMealListener);
        contentPane.add(getMealButton);
    }
    
}
