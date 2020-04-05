package com.prog3.zensurenspiegel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Zensurenspiegel {
    int highestGrade = 0;
    int[] anzahlNoten;
    private Scanner scanner;

    public Zensurenspiegel() {
        scanner = new Scanner(System.in);
        printExplaination();
        askMaxGrade();
        nextGrade(askGrade());
        printGradeCount();
        printScore();
    }

    private void printGradeCount() {
        System.out.println("Note|Anzahl");
        for (int grade = 1; grade <= anzahlNoten.length; grade++) {
            System.out.printf("%2d | %2d \n", grade, anzahlNoten[grade - 1]);
        }
    }

    private void askMaxGrade() {
        System.out.print("Geben sie die höchste mögliche Note an: ");
        highestGrade = askNumber();
        anzahlNoten = new int[highestGrade];
    }

    private void printScore() {
            System.out.printf("Ergibt einen Zensurenspiegel von: %.2f", getScore());
    }

    private double getScore() {
        int sum = 0;
        int quantity = 0;
        for (int grade = 1; grade <= anzahlNoten.length; grade++) {
            sum += anzahlNoten[grade - 1] * grade;
            quantity += anzahlNoten[grade - 1];
        }
        return (double) sum / (double) quantity;
    }

    private void printExplaination() {
        System.out.println("Zensurenspiegel");
        System.out.println("Geben Sie nacheinander die Noten (keine Zwischennoten -ganzzahlig) aller Studenten " + "an. Die Anga-be einer der höchsten Note +1 beendet die Eingabe. Das Programm " + "gibt dann " + "aus, wie oft jede Note vorkam und den Durchschnitt.");
    }

    private int askGrade() {
        System.out.print("Note: ");
        return askNumber();
    }

    private int askNumber() {
        int number;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            printError(1);
            number = askNumber();
        }
        return number;
    }

    private void nextGrade(int grade) {
        if (0 < grade && grade <= highestGrade) {
            anzahlNoten[grade - 1]++;
            nextGrade(askGrade());
        } else if (grade == highestGrade + 1) {
            printError(0);
        } else {
            printError(2);
            nextGrade(askGrade());
        }
    }

    private void printError(int errorNumber) {
        String out = "Das war keine gültige Zahl. ";
        switch (errorNumber) {
            case 0:
                out = "Eingabe erfolgreich beendet!";
                break;
            case 1:
                out += "Probieren Sie es bitte noch einmal! Z.B. eine '5' für die Note 5.";
                break;
            case 2:
                out += "Bitte geben Sie eine Zahl zwischen 1 und " + highestGrade + " als Note ein. Am Ende aller " + "Eingaben geben Sie " + "bitte " + "eine " + (highestGrade + 1) + " ein!";
                break;
        }
        System.out.println(out);
    }

}
