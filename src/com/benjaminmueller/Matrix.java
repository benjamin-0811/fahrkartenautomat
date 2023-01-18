package com.benjaminmueller;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie eine Zahl zwischen 2 und 9 ein: ");
        int mark = scanner.nextInt();
        for (int i = 0; i < 100; i++) {
            boolean isMarked = containsDigit(i, mark) || isDivisibleBy(i, mark) || isChecksum(i, mark);
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.printf(isMarked ? "*\t" : "%d\t", i);
        }
    }

    public static boolean containsDigit(int number, int digit) {
        return Integer.toString(number).contains(Integer.toString(digit));
    }

    public static boolean isDivisibleBy(int dividend, int divisor) {
        return dividend % divisor == 0;
    }

    public static boolean isChecksum(int number, int checksum) {
        char[] digits = Integer.toString(number).toCharArray();
        int realChecksum = 0;
        for (char digit : digits) {
            realChecksum += Integer.parseInt(String.valueOf(digit));
        }
        return checksum == realChecksum;
    }
}
