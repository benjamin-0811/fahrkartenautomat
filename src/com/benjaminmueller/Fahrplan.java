package com.benjaminmueller;

@SuppressWarnings("all")
public class Fahrplan {
    public static void main(String[] args) {

        // Weichestellungen
        int fahrzeit = 0;
        char haltInSpandau = 'n';
        char richtungHamburg = 'n';
        char haltInStendal = 'j';
        char endetIn = 'h';

        fahrzeit += 8; // Fahrzeit Berlin Hbf -> Spandau

        if (haltInSpandau == 'j') fahrzeit += 2; // Halt in Spandau
        if (richtungHamburg == 'j') { // Fahrt Richtung Hamburg, Fahrt endet dort
            fahrzeit += 96;
            message("Hamburg", fahrzeit);
            return;
        }
        fahrzeit += 34; // Fahrzeit Spandau -> Haltepunkt östlich von Stendal
        fahrzeit += haltInStendal == 'j' ? 16 : 6; // Fahrzeit mit Halt in Stendal oder ohne
        switch(endetIn) {
            case 'w':
                fahrzeit += 29; // Fahrt Richtung Wolfsburg, Fahrt endet dort
                message("Wolfsburg", fahrzeit);
                return;
            case 'b':
                fahrzeit += 50; // Fahrt Richtung Braunschweig, Fahrt endet dort
                message("Braunschweig", fahrzeit);
                return;
            default: // Einziger anderer case ist 'h' für Hannover.
                fahrzeit += 62; // Fahrt Richtung Hannover, Fahrt endet dort
                message("Hannover", fahrzeit);
                return;
        }
    }

    private static void message(String halt, int dauer) {
        System.out.printf("Sie erreichen %s nach %d Minuten\n", halt, dauer);
    }
}
