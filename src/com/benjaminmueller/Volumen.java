package com.benjaminmueller;

public class Volumen {
    public static void main(String[] args) {
        System.out.println(volume(1.3, 3.4, 5.6));
        System.out.println(volume(2.0, 3.0, 4.0));
    }

    private static double volume(double x, double y, double z) {
        return x * y * z;
    }
}
