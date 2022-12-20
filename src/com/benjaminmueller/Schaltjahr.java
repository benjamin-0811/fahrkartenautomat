package com.benjaminmueller;

import java.util.Scanner;

public class Schaltjahr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie eine Jahreszahl ein: ");
        if (IsLeapYear(scanner.nextInt()))
            System.out.println("Es handelt sich um ein Schaltjahr.");
        else
            System.out.println("Es handelt sich um kein Schaltjahr.");
    }

    public static boolean IsLeapYear(int year) {
        // Schaltjahre wurden erst 45 v.Chr. eingeführt
        if(year < -45)
            return false;
        boolean multipleOf4 = year % 4 == 0;
        // von 45 v.Chr. bis vor 1582 n.Chr. galt nur Regel 1: vielfaches von 4.
        if(year < 1582 )
            return multipleOf4;
        // ab 1582 gelten weitere Regeln.
        boolean multipleOf100 = year % 100 == 0;
        boolean multipleOf400 = year % 400 == 0;
        // vielfache von 100 überschreiben Regel 1 und es ist kein Schaltjahr
        // vielfache von 400 überschreiben Regel 2 und es ist doch ein Schaltjahr
        return multipleOf4 && !multipleOf100 || multipleOf400;
    }
}
