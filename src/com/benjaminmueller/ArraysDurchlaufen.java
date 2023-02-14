package com.benjaminmueller;

public class ArraysDurchlaufen {
    public static void main(String[] args) {
        int[] zahlen = {1, 6, 3, 7, 2, 2, 4, 8};
        for (int i=2; i<=3; i++) {
            printNumberInArray(zahlen, i);
        }
        System.out.println("\n");
        for (int i=0;  i<=zahlen.length;  i++) {
            printNumberInArray(zahlen, i);
        }
        System.out.println("\n");
        for (int i=1; i<=zahlen.length-1; i=i+2) {
            printNumberInArray(zahlen, i);
        }
    }

    public static void printNumberInArray(int[] array, int index) {
        try {
            int i = array[index];
            System.out.print(i + ", ");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.print(e + ",  ");
        }
    }
}
