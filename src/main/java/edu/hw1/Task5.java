package edu.hw1;

public class Task5 {
    private Task5() {
    }

    private static final int TEN = 10;

    public static boolean isPalindromeDescendant(String strNum) {
        if (isPalindrome(Integer.parseInt(strNum))) {
            return true;
        } else if (strNum.length() > 1) {
            var sb = new StringBuilder();
            for (int i = 0; i < strNum.length() - 1; i += 2) {
                int currentDigit = Integer.parseInt(String.valueOf(strNum.charAt(i)));
                int nextDigit = Integer.parseInt(String.valueOf(strNum.charAt(i + 1)));
                sb.append(currentDigit + nextDigit);
            }

            if (sb.length() == 1) {
                return false;
            }

            return isPalindromeDescendant(sb.toString());
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(int num) {
        int result = 0;
        for (int b = num; b > 0; b /= TEN) {
            result *= TEN;
            result += b % TEN;
        }
        return result == num;
    }
}
