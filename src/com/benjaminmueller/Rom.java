package com.benjaminmueller;

import java.util.*;

public class Rom {
    public static final LinkedHashMap<Character, Integer> ROMAN_NUMERALS = new LinkedHashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie eine römische Zahl ein (1 - 3999 ; I - MMMCMXCIX): ");
        String romanNumber = scanner.next();
        Integer arabicNumber = romanToArabicNumber(romanNumber);
        if (arabicNumber == null) {
            System.out.printf("Die römische Zahl %s existiert nicht.", romanNumber);
        }
        else {
            System.out.printf("Die römische Zahl %s entspricht der Dezimalzahl %d.\n", romanNumber, arabicNumber);
        }
    }

    public static Integer romanToArabicNumber(String romanNumber) {
        int repeats = 1;
        int result = 0;
        int previous = 0;
        Integer[] numeralValues = convertNumeralsToValues(romanNumber);
        if (Arrays.asList(numeralValues).contains(null)) {
            return null;
        }
        for (int i = numeralValues.length - 1; i >= 0; i--) {
            int numeral = numeralValues[i];
            if (numeral >= previous) {
                result += numeral;
                if (numeral == previous) {
                    // if the numeral is not repeatable, don't
                    if (!isRepeatable(numeral)) {
                        return null;
                    }
                    repeats += 1;
                    // numerals shouldn't repeat more than 3 times
                    if (repeats >= 4) {
                        return null;
                    }
                }
                else {
                    repeats = 1;
                }
            }
            else {
                // the smaller numeral can only come before a single bigger one
                if (repeats >= 2) {
                    return null;
                }
                result -= numeral;
                repeats = 1;
            }
            previous = numeral;
        }
        return result;
    }

    public static Integer[] convertNumeralsToValues(String romanNumber) {
        int len = romanNumber.length();
        Integer[] numeralValues = new Integer[len];
        for (int i = 0; i < len; i++) {
            numeralValues[i] = ROMAN_NUMERALS.get(romanNumber.charAt(i));
        }
        return numeralValues;
    }

    public static boolean isRepeatable(int numeral) {
        return numeral == 1 || numeral == 10 || numeral == 100 || numeral == 1000;
    }
}
