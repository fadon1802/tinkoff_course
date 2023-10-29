package edu.hw3;

import java.util.NavigableMap;
import java.util.TreeMap;

@SuppressWarnings("MagicNumber")
public class Task4 {
    private static final NavigableMap<Integer, String> ARAB_TO_ROMAN_DICT = new TreeMap<Integer, String>() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    private Task4() {
    }

    public static String convertToRoman(Integer input) {
        var inputCopy = input;
        if (inputCopy >= 4000 || inputCopy <= 0) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (Integer key : ARAB_TO_ROMAN_DICT.descendingKeySet()) {
            while (inputCopy >= key) {
                inputCopy -= key;
                result.append(ARAB_TO_ROMAN_DICT.get(key));
            }
        }
        return result.toString();
    }
}
