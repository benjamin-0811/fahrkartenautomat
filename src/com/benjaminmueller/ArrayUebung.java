package com.benjaminmueller;

public class ArrayUebung {

    public static void main(String args[]) {

        // 1. Deklaration eines Arrays für ganze Zahlen.
        int[] zahlen;

        // 2. Initialisierung des Arrays mit 100 Elementen.
        zahlen = new int[100];

        // 3. Durchlaufen des gesamten Arrays und Ausgabe des Inhalts.
        printAllArrayValues(zahlen);

        // 4. Das Array mit allen ganzen Zahlen von 1 bis 100 befüllen.
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = i + 1;
        }

        // 5. Geben Sie den Wert an der 89. Position des Arrays aus.
        System.out.println(zahlen[88]);

        // 6. Ändern Sie den Wert des Arrayelements mit dem Index 49 zu 1060.
        zahlen[49] = 1060;

        // Außerdem ändern Sie den Wert an der ersten und der letzten Stelle des Arrays zu 2023.
        zahlen[0] = zahlen[zahlen.length - 1] = 2023;

        // 7. Erneutes Ausgeben des Arrayinhalts. Darstellung: Index und zugehöriger Inhalt (z.B. Index 6 - Inhalt: 7)
        printAllArrayValues(zahlen);

        // 8. Berechnung des Durchschnitts aller Arrayelemente
        double durchschnitt = average(zahlen);
        System.out.printf("Durchschnitt aller Elemente: %f", durchschnitt);

    }

    public static void printAllArrayValues(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Index %d - Inhalt %s,\n", i, array[i]);
        }
        System.out.println();
    }

    public static double average(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double)sum / array.length;
    }
}