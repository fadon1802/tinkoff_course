package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    private Task6() {
    }

    private static final int KAPREKAR_NUM = 6174;
    private static final int DENOMINATOR = 1111;
    private static final int NEED_AMOUNT = 4;

    public static int countK(String strNumber) {
        if (strNumber.length() != NEED_AMOUNT | Integer.parseInt(strNumber) % DENOMINATOR == 0) {
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
