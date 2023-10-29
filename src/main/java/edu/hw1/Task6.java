package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    private Task6() {
    }

    private static final int KAPREKAR_NUM = 6174;
    private static final int DENOMINATOR = 1111;
    private static final int MIN_NUMBER = 1001;
    private static final int MAX_NUMBER = 9999;

    public static int countK(String strNumber) {
        if (Integer.parseInt(strNumber) < MIN_NUMBER || Integer.parseInt(strNumber) > MAX_NUMBER
            || Integer.parseInt(strNumber) % DENOMINATOR == 0) {
            return -1;
        }

        var list = Arrays.asList(strNumber.split(""));
        Collections.sort(list);
        var descNum = Integer.parseInt(String.join("", list));
        Collections.reverse(list);
        var reversedNum = Integer.parseInt(String.join("", list));
        var diff = reversedNum - descNum;
        if (diff == KAPREKAR_NUM) {
            return 1;
        }

        return 1 + countK(String.valueOf(diff));
    }
}
