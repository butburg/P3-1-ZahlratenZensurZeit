package com.prog3.ratespiel;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ratespiel {
    private int secretNumber;
    private int attempts = 0;

    public Ratespiel() {
        generateNumber();
        Scanner scanner = new Scanner(System.in);
        printExplaination();
        nextRound(askInput());
    }

    private void printExplaination() {
        System.out.println("Zahlen-Ratespiel");
        System.out.println(" Das schaffst Du nie!\n Ich denke mir eine ganze Zahl von 0 bis 100 \n und Du musst " + "erraten, " + "welche " + "es" + " ist.");
    }

    private int askInput() {
        System.out.print("Gebe bitte eine ganze Zahl von 0 bis 100 ein: ");
        Scanner scanner = new Scanner(System.in);
        int tip;
        try {
            tip = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Das war keine ganze Zahl, oder? Probiere es bitte noch einmal!\nVersuche es mit " +
                    "einer " + "Zahl " + "zwischen 0 und 100, BITTE! \nZ.B. eine '5'?");
            tip = askInput();
        }
        return tip;
    }


    private void nextRound(int guess) {
        attempts++;
        if (guess < secretNumber) {
            printOutput(0);
            guess = askInput();
            nextRound(guess);
        } else if (guess > secretNumber) {
            printOutput(1);
            guess = askInput();
            nextRound(guess);
        } else {
            printOutput(2);
        }
    }

    private void printOutput(int result) {
        String out = "";
        switch (result) {
            case 0:
                out = "Falsch, meine Zahl ist größer als Du dachtest!\n";
                break;
            case 1:
                out = "Leider Falsch, die zu erratene Zahl ist doch etwas kleiner als Du dachtest!\n";
                break;
            case 2:
                String attempt_str = " Versuche";
                if (attempts == 1)
                    attempt_str = " Versuch";

                out = "\nRICHTIG GERATEN! Das gibt es doch gar nicht! Wie hast Du das nur geschafft?";
                out += "\nDu hast auch nur " + attempts + attempt_str + " gebraucht! Auf Wiedersehen!";
                break;
        }
        System.out.println(out);
    }

    private void generateNumber() {
        secretNumber = (int) (100 * Math.random());
    }
}
