package edu.hw1;

import static java.lang.Math.abs;

public class Task2 {
    private Task2() {
    }

    private static final int TEN = 10;

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        var count = 0;
        var num = number;

        while (abs(num) > 0) {
            num /= TEN;
            count++;
        }

        return count;
    }
}
