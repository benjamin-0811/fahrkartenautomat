package com.benjaminmueller;

import java.util.Scanner;

public class Zinseszins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie die Laufzeit des Vertrags in Jahren an: ");
        int laufzeit = scanner.nextInt();
        System.out.print("Bitte geben Sie an, wie viel Kapital Sie anlegen: ");
        double kapital = scanner.nextDouble();
        System.out.print("Bitte geben Sie den Zinssatz (in %) an:");
        double zinssatz = scanner.nextDouble();

        System.out.printf("Eingezahltes Kapital: %.2f Euro\n", kapital);
        for (int i = 0; i < laufzeit; i++) {
            kapital *= 1 + zinssatz / 100;
        }
        System.out.printf("Ausgezahltes Kapital: %.2f Euro\n", kapital);
    }
}
