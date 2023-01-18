package com.benjaminmueller;

public class Summe {
    public static void main(String[] args) {
        int a = -5; // 1
        int b = 9; // 1
        int ergebnis;
        ergebnis = summe(a, b); // 2
        System.out.println("Summe der Menge: " + ergebnis);
    }

    public static int summe(int start, int ende) { // 3
        int wert = 0; // 4
        for (int i = start; i <= ende; i++) { // 4
            wert = wert + i; // 4
        } // 4
        return wert; // 5
    }
}
