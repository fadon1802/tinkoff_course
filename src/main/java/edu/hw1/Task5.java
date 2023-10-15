package edu.hw1;

public class Task5 {
    public static boolean isPalindromeDescendant(int number) {
        var strNum = String.valueOf(number);
        if (isPalindrome(number)) {
            return true;
        } else if (strNum.length() > 1) {
            var sb = new StringBuilder();
            for (int i = 0; i < strNum.length() - 1; i += 2) {
                sb.append(Integer.parseInt(String.valueOf(strNum.charAt(i))) +
                    Integer.parseInt(String.valueOf(strNum.charAt(i + 1))));
            }

            var num = Integer.parseInt(sb.toString());
            if (sb.toString().length() == 1) {
                return false;
            }
            return isPalindromeDescendant(num);
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(int num) {
        int result = 0;
        for (int b = num; b > 0; ) {
            result *= 10;
            result += b % 10;
            b /= 10;
        }
        return result == num;
    }
}
