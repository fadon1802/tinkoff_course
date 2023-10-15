package edu.hw1;

public class Task4 {
    public static String fixString(String brokenStr) {
        var sb = new StringBuilder();
        for (var i = 0; i < brokenStr.length() - 1; i += 2) {
            var temp1 = brokenStr.charAt(i);
            var temp2 = brokenStr.charAt(i + 1);
            sb.append(new char[] {temp2, temp1});
            if (i == brokenStr.length() - 3) {
                sb.append(brokenStr.charAt(i + 2));
            }
        }

        return sb.toString();
    }
}
