package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {

    private Task6() {
    }

    public static boolean isSubstring(String string, String subString) {
        var regex = "^.*" + subString + ".*$";
        Pattern pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(string);
        return matcher.matches();

    }
}
