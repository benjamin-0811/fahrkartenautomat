package com.benjaminmueller;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Urlaub {
    @SuppressWarnings("unused")
    public static class WaehrungVerglichenMitEuro {
        private final String LAND;
        private double wertInEuro;
        private String waehrung;

        public WaehrungVerglichenMitEuro(String land, double wertInEuro, String waehrung) {
            this.LAND = land;
            this.wertInEuro = wertInEuro;
            this.waehrung = waehrung;
        }

        public String getLand() {
            return LAND;
        }

        public double getWertInEuro() {
            return wertInEuro;
        }

        public void setWertInEuro(double wertInEuro) {
            this.wertInEuro = wertInEuro;
        }

        public String getWaehrung() {
            return waehrung;
        }
        public void setWaehrung(String waehrung) {
            this.waehrung = waehrung;
        }
    }

    public static final LinkedHashMap<Character, WaehrungVerglichenMitEuro> WAEHRUNGSTABELLE = new LinkedHashMap<Character, WaehrungVerglichenMitEuro>() {{
        put('u', new WaehrungVerglichenMitEuro("USA", 0.98, "Dollar"));
        put('j', new WaehrungVerglichenMitEuro("Japan", 141, "Yen"));
        put('e', new WaehrungVerglichenMitEuro("England", 0.88, "Pfund"));
        put('s', new WaehrungVerglichenMitEuro("Schweiz", 0.96, "Franken"));
        put('d', new WaehrungVerglichenMitEuro("Dänemark", 7.44, "Kronen"));
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie lautet ihr Reisebudget?");
        scanPrompt();
        double reisebudget = scanner.nextDouble();
        final double reserve = reisebudget * 0.1;
        double rest = reise(scanner, reisebudget, reserve);
        System.out.printf("Sie sind zurückgekehrt. Sie haben noch %.2f Euro im Budget übrig", rest);
    }

    public static double reise(Scanner scanner, double budget, double reserve) {
        while(true) {
            System.out.printf("Sie haben noch: %.2f Euro\n", budget);
            if (budget < reserve) {
                System.out.printf("Ihr Budget ist mit %.2f Euro unter ihrer Reserve von %.2f Euro gefallen.\n", budget, reserve);
                char antwort = liesAntwort(scanner, "Wollen Sie ihr Budget erhöhen? [j/n]",
                        "Fehlerhafte Eingabe!\nWollen Sie ihr Budget erhöhen? [j/n]");
                if (antwort == 'j') {
                    System.out.println("Bitte geben Sie ein, um wieviel Euro ihr Budget erhöht werden soll.");
                    budget += scanner.nextDouble();
                }
                else {
                    System.out.println("Ihr Budget ist unter ihrer Reserve gefallen und Sie wollten nicht erhöhen,\nalso werden Sie jetzt nach Hause geschickt.");
                    return budget;
                }
            }
            char land = liesLand(scanner, "Wohin soll die Reise gehen?\nUSA (u), Japan(j), England(e), Schweiz(s) oder Dänemark(d):",
                    "Fehlerhafte Eingabe!\nBitte wählen Sie eins der folgenden Länder.\nUSA (u), Japan(j), England(e), Schweiz(s) oder Dänemark(d):");
            double wechselBetrag = liesWechselBetrag(scanner, budget, "Wie viel Geld wollen sie einwechslen?",
                    "Einzuwechselnder Betrag liegt über dem Budget!\nBitte geben Sie einen geringeren Betrag ein.");
            budget -= wechselBetrag;
            WaehrungVerglichenMitEuro wvme = WAEHRUNGSTABELLE.get(land);
            System.out.printf("Sie reisen Nach %s und tauschen %.2f Euro gegen %.2f %s ein\n", wvme.getLand(), wechselBetrag, wvme.getWertInEuro() * wechselBetrag, wvme.getWaehrung());
        }
    }

    public static void scanPrompt() {
        System.out.print("Ihre Eingabe: ");
    }

    public static char liesAntwort(Scanner scanner, String frage, String frageBeiFehler) {
        System.out.println(frage);
        scanPrompt();
        char antwort = scanner.next().toLowerCase().charAt(0);
        while (antwort != 'j' && antwort != 'n') {
            System.out.println(frageBeiFehler);
            scanPrompt();
            antwort = scanner.next().toLowerCase().charAt(0);
        }
        return antwort;
    }

    public static char liesLand(Scanner scanner, String frage, String frageBeiFehler) {
        System.out.println(frage);
        scanPrompt();
        char land = scanner.next().toLowerCase().charAt(0);
        while (!WAEHRUNGSTABELLE.containsKey(land)) {
            System.out.println(frageBeiFehler);
            scanPrompt();
            land = scanner.next().toLowerCase().charAt(0);
        }
        return land;
    }

    public static double liesWechselBetrag(Scanner scanner, double budget, String frage, String frageBeiFehler) {
        System.out.println(frage);
        scanPrompt();
        double wechselBetrag = scanner.nextDouble();
        while (wechselBetrag > budget) {
            System.out.println(frageBeiFehler);
            scanPrompt();
            wechselBetrag = scanner.nextDouble();
        }
        return wechselBetrag;
    }
}
