package com.benjaminmueller;

import java.util.Scanner;

public class Kalender {
    public static void main(String[] args) {
        int tage = 0;
        int monat;
        Scanner tastatur = new Scanner(System.in);

        System.out.println("Wie lautet der Monat (1-12): ");
        monat = tastatur.nextInt();

        switch(monat) {
            default:
                System.out.println("Ungültige Eingabe: Monat wird auf 1 gesetzt.");
                monat = 1;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                tage = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                tage = 30;
                break;
            case 2:
                tage = 28;
                break;
        }

        System.out.printf("Der %d-te Monat im Jahr hat %d Tage.\n", monat, tage);
        tastatur.close();
    }
}
