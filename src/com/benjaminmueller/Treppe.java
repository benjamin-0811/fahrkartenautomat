package com.benjaminmueller;

import java.util.Scanner;

public class Treppe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Treppenhöhe: ");
        int h = scanner.nextInt();
        System.out.print("Stufenbreite: ");
        int b = scanner.nextInt();
        int bGesamt = h * b;
        for (int i = 1; i <= h; i++) {
            int spaceAmount = bGesamt - i * b;
            repeatChar(' ', spaceAmount);
            repeatChar('*', bGesamt - spaceAmount);
            System.out.println();
        }
    }

    public static void repeatChar(char c, int amount) {
        for(int i = 0; i < amount; i++) {
            System.out.print(c);
        }
    }
}
