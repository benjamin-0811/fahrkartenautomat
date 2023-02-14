package com.benjaminmueller;

import java.util.*;

class Fahrkartenautomat {

    @SuppressWarnings("unused")
    public static class TicketType {
        private final String name;
        private double price;

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public TicketType(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private static final ArrayList<Double> VALID_AMOUNTS = new ArrayList<>(Arrays.asList(0.05, 0.1, 0.2, 0.5, 1.0, 2.0, 5.0, 10.0, 20.0));
    private static final TicketType[] TICKET_TYPES = new TicketType[] {
            new TicketType("Einzelfahrschein AB", 3.0), new TicketType("Einzelfahrschein BC", 3.5),
            new TicketType("Einzelfahrschein ABC", 3.8), new TicketType("Kurzstrecke AB", 2.0),
            new TicketType("Tageskarte AB", 8.6), new TicketType("Tageskarte BC", 9.2),
            new TicketType("Tageskarte ABC", 10.0), new TicketType("4-Fahrten-Karte AB", 9.4),
            new TicketType("4-Fahrten-Karte BC", 12.6), new TicketType("4-Fahrten-Karte ABC", 13.8),
            new TicketType("Kleingruppen-Tageskarte AB", 25.5), new TicketType("Kleingruppen-Tageskarte BC", 26.0),
            new TicketType("Kleingruppen-Tageskarte ABC", 26.5)
    };

    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;

        begruessung();
        zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
        eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
        fahrkartenAusgeben();
        rueckgeldAusgeben(zuZahlenderBetrag, eingezahlterGesamtbetrag);

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
        int anzahlTicketTypen = TICKET_TYPES.length;
        int quitNumber = anzahlTicketTypen + 1;
        boolean runLoop = true;
        while (true) {
            System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:");
            for (int i = 0; i < anzahlTicketTypen; i++) {
                double price = TICKET_TYPES[i].getPrice();
                System.out.printf("  %s [%.2f EUR] (%d)\n", TICKET_TYPES[i].getName(), price, i + 1);
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
            double currentPrice = TICKET_TYPES[ticketId - 1].getPrice();

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

    private static void rueckgeldAusgeben(double zuZahlenderBetrag, double eingezahlterGesamtbetrag){
        double rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        if (rueckgabebetrag > 0.0) {
            System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", rueckgabebetrag);
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            rueckgabebetrag = muenzrueckgabe(rueckgabebetrag, 2.0, "2 Euro");
            rueckgabebetrag = muenzrueckgabe(rueckgabebetrag, 1.0, "1 Euro");
            rueckgabebetrag = muenzrueckgabe(rueckgabebetrag, 0.5, "50 Cent");
            rueckgabebetrag = muenzrueckgabe(rueckgabebetrag, 0.2, "20 Cent");
            rueckgabebetrag = muenzrueckgabe(rueckgabebetrag, 0.1, "10 Cent");
            rueckgabebetrag = muenzrueckgabe(rueckgabebetrag, 0.05, "5 Cent");
        }
    }

    private static double muenzrueckgabe(double rueckgabebetrag, double muenzwert, String muenzname) {
        while (rueckgabebetrag >= muenzwert) {
            System.out.println(muenzname);
            rueckgabebetrag = roundEuro(rueckgabebetrag - muenzwert);
        }
        return rueckgabebetrag;
    }
}