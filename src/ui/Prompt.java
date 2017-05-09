/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.util.Scanner;
import logic.GetMeal;

/**
 *
 * @author kari
 */
public class Prompt {

    private Scanner scanner;

    public Prompt() {
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        execute();
    }

    private void execute() throws IOException {
        GetMeal getMeal = new GetMeal();
        while (true) {
            String meal = getMeal.getRandonMeal();
            System.out.println(meal);
            System.out.println("Kuulostaako hyvältä? (k/e)");
            String cmd = scanner.nextLine();
            if (cmd.equalsIgnoreCase("k")) {
                getMeal.addToHistory(meal);
                break;
            } 
        }
    }
}
