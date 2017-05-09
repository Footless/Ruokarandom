/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kari
 */
public class GetMeal {

    private final Scanner scanner;
    private final Scanner historyScanner;
    private FileWriter historyWriter;
    private final FileWriter mealWriter;
    private final List<String> meals;
    private final List<String> history;

    public GetMeal() throws FileNotFoundException, IOException {
        this.meals = new ArrayList<>();
        this.history = new ArrayList<>();
//        this.scanner = new Scanner(new File("src/ruokarandom/ruoat.txt"));
//        this.historyScanner = new Scanner(new File("src/ruokarandom/syodyt.txt"));
        this.scanner = new Scanner(new File("ruoat.txt"));
        this.historyScanner = new Scanner(new File("syodyt.txt"));
        readHistory();
//        this.writer = new FileWriter("src/ruokarandom/syodyt.txt");
        this.mealWriter = new FileWriter("ruoat.txt", true);
    }

    private void readFile() {
        while (scanner.hasNextLine()) {
            meals.add(scanner.nextLine());
        }
    }

    public String getRandonMeal() {
        readFile();
        int seed = new Random().nextInt(meals.size());
        while (true) {            
            if (!history.contains(meals.get(seed))) {
                return meals.get(seed);
            }
        }
        
    }

    private void readHistory() {
        while (historyScanner.hasNextLine()) {
            history.add(historyScanner.nextLine());
        }
    }

    public void addToHistory(String meal) throws IOException {
        this.historyWriter = new FileWriter("syodyt.txt");
        if (history.size() > 7) {
            history.remove(0);
            history.add(meal);
            for (String s : history) {
                historyWriter.write(s + "\n");
            }
            historyWriter.close();
        } else {
            history.add(meal);
            for (String s : history) {
                historyWriter.write(s + "\n");
            }
            historyWriter.close();
        }
    }
    
    public void addMeal(String meal) throws IOException {
        mealWriter.write(meal + "\n");
        mealWriter.close();
    }
}
