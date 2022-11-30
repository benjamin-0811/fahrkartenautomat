package com.benjaminmueller;

import java.util.Scanner;

public class Rabattsystem {
    public static void main(String[] args) {
        double bestellWert, rabatt, wertMinusRabatt;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben Sie Ihren Bestellwert ein: ");
        bestellWert = scanner.nextDouble();
        if (isInRange(bestellWert, 0, 100)) rabatt = 0.1;
        else if (isInRange(bestellWert, 100, 500)) rabatt = 0.15;
        else rabatt = 0.2;

        wertMinusRabatt = bestellWert * (1 - rabatt);

        System.out.printf("Der Bestellwert abzüglich Rabatt beträgt %.2f EUR\n", wertMinusRabatt);
    }

    public static boolean isInRange(double value, double min, double max) {
        return value > min && value <= max;
    }
}
