package com.benjaminmueller;

public class EAN {
    public static void main(String[] args) {
        long[] eanCodes = new long[] {4780201379636L, 2222222222221L, 1234567890128L, 9807522453694L, 7539518524561L};
        for (long eanCode : eanCodes) {
            validierePruefziffer(eanCode);
        }
    }

    public static int getPruefZiffer(long eanCode) {
        int[] artikelnummer = getArtikelnummerAsArray(eanCode);
        array$oddX3(artikelnummer);
        int sum = array$sum(artikelnummer);
        int almost = 10 - (sum % 10);
        return almost == 10 ? 0 : almost;
    }

    public static int[] getArtikelnummerAsArray(long eanCode) {
        char[] nummerString = Long.toString(eanCode).toCharArray();
        int[] ziffern = new int[nummerString.length - 1];
        for (int i = 0; i < ziffern.length; i++) {
            ziffern[i] = Integer.parseInt(Character.toString(nummerString[i]));
        }
        return ziffern;
    }

    public static void array$oddX3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] *= 3;
            }
        }
    }

    public static int array$sum(int[] array) {
        int sum = 0;
        for (int b : array) {
            sum += b;
        }
        return sum;
    }

    public static void validierePruefziffer(long eanCode) {
        long artikelnummer = ziffernZuZahl(getArtikelnummerAsArray(eanCode));
        int pruefZiffer = getPruefZiffer(eanCode);

        System.out.printf("Gegebener EAN-Code lautet: %d\n", eanCode);
        System.out.printf("Artikelnummer: %d\n", artikelnummer);
        System.out.printf("Prüfziffer anhand der Artikelnummer: %d\n", pruefZiffer);

        char[] eanCodeString = Long.toString(eanCode).toCharArray();
        int letzteZiffer = Integer.parseInt(Character.toString(eanCodeString[eanCodeString.length - 1]));

        System.out.println(pruefZiffer == letzteZiffer ? "EAN-Code ist valide." : "EAN-Code ist nicht valide.");
        System.out.println();
    }

    public static long ziffernZuZahl(int[] array) {
        String zahlString = "";
        for (int i : array) {
            zahlString = zahlString.concat(Integer.toString(i));
        }
        return Long.parseLong(zahlString);
    }
}
