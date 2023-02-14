package com.benjaminmueller;

public class Index {
    public static void main(String[] args) {
        int[] zahlen = {1, 6, 3, 7, 2};
        int i = 4;
        printNumberInArray(zahlen, 1);
        printNumberInArray(zahlen, 5);
        printNumberInArray(zahlen, 3);
        printNumberInArray(zahlen, i);
        printNumberInArray(zahlen, i-2);
        printNumberInArray(zahlen, zahlen[4]);
    }

    public static void printNumberInArray(int[] array, int index) {
        try {
            int i = array[index];
            System.out.println(i);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
