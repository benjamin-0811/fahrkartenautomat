package com.benjaminmueller;

import java.util.Scanner;

public class GroessterWert {
    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        int a, b, c, max;

        // Eingabe
        System.out.print("a: ");
        a = tastatur.nextInt();
        System.out.print("b: ");
        b = tastatur.nextInt();
        System.out.print("c: ");
        c = tastatur.nextInt();

        // Verarbeitung
        if (a > c) {
            if (a > b) {
                max = a;
            }
            else {
                max = b;
            }
        }
        else {
            if (b > c) {
                max = b;
            }
            else {
                max = c;
            }
        }

        // Ausgabe
        System.out.printf("Der größte eingegeben Wert ist: %d\n", max);
    }
}
