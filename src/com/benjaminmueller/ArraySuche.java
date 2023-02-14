package com.benjaminmueller;

public class ArraySuche {
    public static void main(String[] args) {
        int[] zahlenArray = { 1, 5, 5, 7, 3, 11, 22, 23, 27 };
        int wert = 3;
        int index = getIndexOfNumberInArray(zahlenArray, wert);
        System.out.println(index != -1 ? "Gefunden!" : "Nicht gefunden!");
    }

    public static int getIndexOfNumberInArray(int[] array, int numberToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numberToFind) {
                return i;
            }
        }
        return -1;
    }
}
