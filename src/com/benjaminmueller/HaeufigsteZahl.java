package com.benjaminmueller;

public class HaeufigsteZahl {
    public static void main(String[] args) {
        int[] zahlen = {3,4,2,3,5,1,2,7,2,1,2,4};
        Integer haeufigste = most(zahlen);
        System.out.println(haeufigste == null ? "Array ist leer! Keine häufigste Zahl gefunden." :
                ("Die häufigste Zahl ist " + haeufigste + " (" + array$count(zahlen, haeufigste) + " Vorkommen)"));
    }
    
    public static Integer most(int[] array) {
        if (array.length == 0) {
            return null;
        }
        else if (array.length == 1) {
            return array[0];
        }
        int[] numbers = new int[0];
        int[] amounts = new int[0];
        for (int current : array) {
            int index = array$indexOf(numbers, current);
            if (index == -1) {
                numbers = array$append(numbers, current);
                amounts = array$append(amounts, 1);
            } else {
                amounts[index]++;
            }
        }
        return numbers[array$indexOfMax(amounts)];
    }

    public static int[] array$append(int[] array, int x) {
        int[] newArray = new int[array.length + 1];
        array$copy(newArray, array);
        newArray[newArray.length - 1] = x;
        return newArray;
    }

    public static void array$copy(int[] target, int[] array) {
        int limit = Math.min(array.length, target.length);
        System.arraycopy(array, 0, target, 0, limit);
    }

    public static int array$indexOf(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int array$indexOfMax(int[] array) {
        int mostAt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[mostAt] < array[i]) {
                mostAt = i;
            }
        }
        return mostAt;
    }

    public static int array$count(int[] array, int x) {
        int amount = 0;
        for (int i : array) {
            if (i == x) {
                amount++;
            }
        }
        return amount;
    }
}
