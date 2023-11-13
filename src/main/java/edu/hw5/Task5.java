package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {
    private Task5() {
    }

    public static boolean isValidLicensePlate(String string) {
        Pattern pattern = Pattern.compile("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{1,3}$");
        var matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
