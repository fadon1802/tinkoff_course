package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String brokenStr) {
        var sb = new StringBuilder();
        if (brokenStr.length() == 1) {
            return brokenStr;
        }

        for (var i = 0; i < brokenStr.length() - 1; i += 2) {
            var temp1 = brokenStr.charAt(i);
            var temp2 = brokenStr.charAt(i + 1);
            sb.append(temp2);
            sb.append(temp1);
            if (i + 1 == brokenStr.length() - 2) {
                sb.append(brokenStr.charAt(i + 2));
            }
        }

        return sb.toString();
    }
}
