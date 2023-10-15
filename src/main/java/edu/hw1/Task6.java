package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    public static int countK(int number){
        if (number < 1000 || number > 9999)
            return -1;

        var l = String.valueOf(number);
        var list = new ArrayList<>(Arrays.asList(l.split("")));
        Collections.sort(list);
        Collections.reverse(list);

        var descNum = Integer.parseInt(String.join("", list));
        var diff = descNum - ReverseNumber(descNum);
        if (diff == 6174)
            return 1;

        return 1 + countK(diff);
    }

    public static int ReverseNumber(int n) {
        int result = 0;
        while (n != 0) {
            int remainder = n % 10;
            result = result * 10 + remainder;
            n = n / 10;
        }
        return result;
    }
}
