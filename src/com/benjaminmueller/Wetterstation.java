package com.benjaminmueller;

public class Wetterstation {
    public static void main(String[] args) {
        double[] wetterdaten = {
                -15.55, -2.55, -11.44, -8.6, -14.4, -5.17, 1.48, -3.47, 2.00, 2.14,
                4.05, 7.45, 3.25, 5.04, 11.4, 7.67, 8.64, 13.28, 6.87, 15.54,
                12.45, 16.55, 20.42, 22.38, 19.58, 18.85, 23.84, 24.42, 25.54, 28.35,
                30.16, 32.44, 26.55, 22.13, 16.64, 13.33, 16.45, 17.34, 15.33, 11.13,
                15.16, 11.44, 6.55, 2.13, 6.64, 3.33, 6.45, -1.34, 5.33, -11.15
        };
        System.out.printf("Anzahl der Daten: %d\n", wetterdaten.length);
        System.out.printf("Durchschnittstemperatur: %.2f\n", array$average(wetterdaten));
        System.out.printf("Minimum: %.2f\n", array$min(wetterdaten));
        System.out.printf("Maximum: %.2f\n", array$max(wetterdaten));
        System.out.printf("Umschwung: %.2f\n", array$highestDifference(wetterdaten));
    }

    public static double array$average(double[] array) {
        double sum = 0;
        for (double i : array) {
            sum += i;
        }
        return sum / array.length;
    }

    public static double array$min(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        else if (array.length == 1) {
            return array[0];
        }
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static double array$max(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        else if (array.length == 1) {
            return array[0];
        }
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static double array$highestDifference(double[] array) {
        if (array.length == 0 || array.length == 1) {
            return 0;
        }
        double hdiff = Math.abs(array[1] - array[0]);
        for (int i = 2; i < array.length; i++) {
            double cdiff = Math.abs(array[i] - array[i - 1]);
            if (cdiff > hdiff) {
                hdiff = cdiff;
            }
        }
        return hdiff;
    }
}
