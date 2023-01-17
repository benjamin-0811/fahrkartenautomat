package com.benjaminmueller;

public class Schleifen {
    public static void main(String[] args) {
        zaehlschleifeVorgabe();
        zaehlschleifeZehnBisZwanzig();
        bedingungsschleife();
        bedingungsschleifeZehnBisZwanzig();
        // bedingungsschleifeMitBreakUndContinue();
        /*
         * durch das continue bei i == 11 wird i nicht erhöht, wodurch die Schleife endlos wird.
         */
        bedingungsschleifeZusatz();
    }

    public static void zaehlschleifeVorgabe() {
        System.out.println("Beispiel Zählschleife (1 - 10):");
        for(int i = 1; i <= 10; i = i + 1) {
            System.out.printf("%d ", i * i);
        }
        System.out.println();
    }

    public static void zaehlschleifeZehnBisZwanzig() {
        System.out.println("Beispiel Zählschleife (10 - 20):");
        for(int i = 10; i <= 20; i = i + 1) {
            System.out.printf("%d ", i * i);
        }
        System.out.println();
    }

    public static void bedingungsschleife() {
        System.out.println("Beispiel Bedingingsschleife (1 - 10):");
        int i = 1;
        while(i <= 10) {
            System.out.printf("%d ", i*i);
            i = i+1;
        }
        System.out.println();
    }

    public static void bedingungsschleifeZehnBisZwanzig() {
        System.out.println("Beispiel Bedingingsschleife (10 - 20):");
        int i = 10;
        while(i <= 20) {
            System.out.printf("%d ", i*i);
            i = i+1;
        }
        System.out.println();
    }

    @SuppressWarnings("unused")
    public static void bedingungsschleifeMitBreakUndContinue() {
        System.out.println("Beispiel Bedingingsschleife (break, continue):");
        int i = 10;
        while(i <= 20) {
            if (i == 18) break;
            if (i == 11) continue;
            System.out.printf("%d ", i*i);
            i = i+1;
        }
        System.out.println();
    }

    public static void bedingungsschleifeZusatz() {
        System.out.println("Beispiel Bedingingsschleife (Zusatz):");
        int i = 10;
        while(i <= 20) {
            if (i == 18) break;
            if (i == 11) {
                i += 1;
                continue;
            }
            System.out.printf("%d ", i*i);
            i = i+1;
        }
        System.out.println();
    }
}
