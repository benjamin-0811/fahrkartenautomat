package com.benjaminmueller;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        double gewicht, groesse, bmi;
        char geschlecht;
        int min, max;
        String klassifikation;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben Sie Ihre Körpergröße in cm an: ");
        groesse = scanner.nextDouble();
        System.out.print("Bitte geben Sie jetzt Ihr Gewicht in kg an: ");
        gewicht = scanner.nextDouble();
        System.out.print("Als Letztes geben Sie bitte Ihr Geschlecht an m/w: ");
        geschlecht = scanner.next().trim().charAt(0);

        bmi = gewicht / Math.pow(groesse / 100, 2);

        min = geschlecht == 'm' ? 20 : 19;
        max = geschlecht == 'm' ? 25:  24;

        if (bmi < min) klassifikation = "Untergewicht";
        else if (bmi > max) klassifikation = "Übergewicht";
        else klassifikation = "Normalgewicht";

        System.out.printf("Sie haben %s | BMI : %.2f\n", klassifikation, bmi);
    }
}
