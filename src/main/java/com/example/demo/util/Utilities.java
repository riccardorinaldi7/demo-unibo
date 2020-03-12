package com.example.demo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Utilities {

    public static List<String> inizializzaOccasioni() {
        List<String> deck = new ArrayList<String>();

        try {
            File myObj = new File(Utilities.class.getClassLoader().getResource("CarteOccasioni.txt").getFile());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);

                deck.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        Collections.shuffle(deck);
        System.out.println(deck.toString());
        return deck;
    }

    public static List<String> inizializzaEsperienze() {
        List<String> deck = new ArrayList<String>();

        try {
            File myObj = new File(Utilities.class.getClassLoader().getResource("CarteEsperienza.txt").getFile());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);

                deck.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        Collections.shuffle(deck);
        System.out.println(deck.toString());
        return deck;
    }
}
