package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private Task4() {
    }

    public static boolean hasSpecificSymbol(String string) {
        Pattern pattern = Pattern.compile("^.*[~!@#$%^&*|].*$");
        var matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
