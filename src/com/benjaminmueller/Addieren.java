package com.benjaminmueller;

import java.util.Scanner;

public class Addieren {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie eine Zahl ein: ");
        int n = scanner.nextInt();
        int sum = 0;
        System.out.println("Vorwärts addieren:");
        System.out.println("\nDie Zahlen werden addiert.");
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
            sum += i;
        }
        System.out.printf("\nDie Summe beträgt: %d\n", sum);

        sum = 0;
        System.out.print("\n\n");

        System.out.println("Rückwärts addieren:");
        System.out.println("\nDie Zahlen werden addiert.");
        for (int i = n; i > 0; i--) {
            System.out.println(i);
            sum += i;
        }
        System.out.printf("\nDie Summe beträgt: %d\n", sum);
    }
}
