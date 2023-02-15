package com.benjaminmueller;

public class SelectionSort {
    public static void main(String[] args) {
        int[] liste = { 4, 2, 10, 3, -5, 0, 17 };
        selectionSort(liste);
        for (int i : liste) {
            System.out.printf("%d, ", i);
        }
    }

    public static void selectionSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
