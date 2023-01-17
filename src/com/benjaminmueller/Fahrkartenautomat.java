package com.benjaminmueller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Fahrkartenautomat {

    private static final ArrayList<Double> VALID_AMOUNTS = new ArrayList<>(Arrays.asList(0.05, 0.1, 0.2, 0.5, 1.0, 2.0, 5.0, 10.0, 20.0));

    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;
        double rueckgabebetrag;
        double nochZuZahlen;
        int ticketAnzahl;

        // // 1 : Geldbetrag eingeben
        // System.out.print("Zu zahlender Betrag (Euro): ");
        // zuZahlenderBetrag = tastatur.nextDouble();

        // 1.1 : Ticketpreis eingeben
        System.out.print("Ticketpreis (Euro): ");
        zuZahlenderBetrag = tastatur.nextDouble();

        // 1.2 : Anzahl der Tickets eingeben
        System.out.print("Anzahl der Tickets: ");
        ticketAnzahl = tastatur.nextInt();

        // 5.2 : Wiederholung der Eingabe der Ticketanzahl
        while (ticketAnzahl > 10 || ticketAnzahl < 1) {
            System.out.print(" >> Wählen Sie bitte eine Anzahl von 1 bis 10 aus. <<");
            System.out.print("Anzahl der Tickets: ");
            ticketAnzahl = tastatur.nextInt();
        }

        // 4.4 validiere die Anzahl der Tickets
        /*
         * if (ticketAnzahl < 1 || ticketAnzahl > 10) {
         *     System.out.print("Fehlerhafte Eingabe - Ticketanzahl wird auf 1 gesetzt");
         *     ticketAnzahl = 1;
         * }
         */

        zuZahlenderBetrag *= ticketAnzahl;

        // 2 : Geldeinwurf
        eingezahlterGesamtbetrag = 0.0;
        nochZuZahlen = 0.0;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            if (isValidAmountOfMoney(eingeworfeneMuenze)) eingezahlterGesamtbetrag += eingeworfeneMuenze;
            else System.out.println(">> Kein gültiges Zahlungsmittel");
        }

        // 3 : Fahrscheinausgabe
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");

        // 4 : Rückgeldberechung und -ausgabe
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        if (rueckgabebetrag > 0.0) {
            System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", rueckgabebetrag);
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabebetrag -= 2.0;
            }
            while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag -= 1.0;
            }
            while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag -= 0.5;
            }
            while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag -= 0.2;
                rueckgabebetrag = roundEuro(rueckgabebetrag);
            }
            while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag -= 0.1;
                rueckgabebetrag = roundEuro(rueckgabebetrag);
            }
            while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabebetrag -= 0.05;
                rueckgabebetrag = roundEuro(rueckgabebetrag);
            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }

    private static double roundEuro(double x) {
        return Math.round(x * 100) / 100.0d;
    }

    private static boolean isValidAmountOfMoney(double amount) {
        return VALID_AMOUNTS.contains(amount);
    }
}