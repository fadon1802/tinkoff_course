package edu.hw3;

import java.util.ArrayList;

public class Task1 {
    private Task1() {
    }

    private static final ArrayList<Character> LETTERS = new ArrayList<>() {{
        for (char c = 'a'; c <= 'z'; c++) {
            add(c);
        }
    }};

    public static String atbash(String sentence) {
        var result = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            var currentChar = sentence.charAt(i);
            boolean isUpper = Character.isUpperCase(currentChar);
            int index = LETTERS.indexOf(Character.toLowerCase(currentChar));
            if (index == -1) {
                result.append(currentChar);
                continue;
            }

            char resChar = LETTERS.get(LETTERS.size() - index - 1);
            result.append(isUpper ? Character.toUpperCase(resChar) : resChar);
        }

        return result.toString();
    }
}
