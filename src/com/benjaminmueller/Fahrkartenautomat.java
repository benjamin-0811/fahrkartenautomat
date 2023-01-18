package com.benjaminmueller;

import java.util.*;

class Fahrkartenautomat {

    private static final ArrayList<Double> VALID_AMOUNTS = new ArrayList<>(Arrays.asList(0.05, 0.1, 0.2, 0.5, 1.0, 2.0, 5.0, 10.0, 20.0));
    private static final LinkedHashMap<String, Double> PriceByTicketType = new LinkedHashMap<String, Double>() {{
        put("Kurzstrecke AB", 2.0);
        put("Einzelfahrschein AB", 3.0);
        put("Tageskarte AB", 8.8);
        put("4-Fahrten-Karte AB", 9.8);
    }};

    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        double rueckgabebetrag;

        begruessung();
        zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
        eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
        fahrkartenAusgeben();

        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        if (rueckgabebetrag > 0.0) {
            System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", rueckgabebetrag);
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabebetrag -= 2.0;
            }
            while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag -= 1.0;
            }
            while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag -= 0.5;
            }
            while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag -= 0.2;
                rueckgabebetrag = roundEuro(rueckgabebetrag);
            }
            while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag -= 0.1;
                rueckgabebetrag = roundEuro(rueckgabebetrag);
            }
            while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabebetrag -= 0.05;
                rueckgabebetrag = roundEuro(rueckgabebetrag);
            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }

    private static double roundEuro(double x) {
        return Math.round(x * 100) / 100.0d;
    }

    private static boolean isValidAmountOfMoney(double amount) {
        return VALID_AMOUNTS.contains(amount);
    }

    private static void begruessung() {
        System.out.println("Herzlich Willkommen!\n");
    }

    private static double fahrkartenbestellungErfassen(Scanner tastatur) {
        double zuZahlenderBetrag = 0;
        int anzahlTicketTypen = PriceByTicketType.size();
        int quitNumber = anzahlTicketTypen + 1;
        double[] priceArray = new double[anzahlTicketTypen];
        boolean runLoop = true;
        while (true) {
            System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:");
            int priceByTicketTypeIndex = 0;
            for (String key : PriceByTicketType.keySet()) {
                double price = PriceByTicketType.get(key);
                priceArray[priceByTicketTypeIndex] = price;
                System.out.printf("  %s [%.2f EUR] (%d)\n", key, price, priceByTicketTypeIndex + 1);
                priceByTicketTypeIndex++;
            }
            System.out.printf("  Bezahlen (%d)\n", quitNumber);
            System.out.print("Ihre Wahl: ");
            int ticketId = tastatur.nextInt();
            while (ticketId > anzahlTicketTypen || ticketId < 1) {
                if (ticketId == quitNumber) {
                    runLoop = false;
                    break;
                }
                System.out.println(" >>falsche Eingabe<<");
                ticketId = tastatur.nextInt();
            }
            if (!runLoop)
                break;
            double currentPrice = priceArray[ticketId - 1];

            System.out.print("Anzahl der Tickets: ");
            int ticketAnzahl = tastatur.nextInt();

            while (ticketAnzahl > 10 || ticketAnzahl < 1) {
                System.out.println(" >> Wählen Sie bitte eine Anzahl von 1 bis 10 aus. <<");
                System.out.print("Anzahl der Tickets: ");
                ticketAnzahl = tastatur.nextInt();
            }

            zuZahlenderBetrag += currentPrice * ticketAnzahl;
            System.out.printf("Zwischensumme: %.2f €\n", zuZahlenderBetrag);
        }
        return zuZahlenderBetrag;
    }

    private static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
        double eingezahlterGesamtbetrag = 0.0;
        double nochZuZahlen;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
            double eingeworfeneMuenze = tastatur.nextDouble();
            if (isValidAmountOfMoney(eingeworfeneMuenze)) eingezahlterGesamtbetrag += eingeworfeneMuenze;
            else System.out.println(">> Kein gültiges Zahlungsmittel");
        }
        return eingezahlterGesamtbetrag;
    }

    private static void fahrkartenAusgeben() {
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");
    }
}