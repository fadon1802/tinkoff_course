package edu.hw1;

import java.util.Arrays;

public class Task3 {
    public static boolean isNestable(int[] a1, int[] a2){
        var min1 = Arrays.stream(a1).min().getAsInt();
        var min2 = Arrays.stream(a2).min().getAsInt();
        var max1 = Arrays.stream(a1).max().getAsInt();
        var max2 = Arrays.stream(a2).max().getAsInt();
        return min1 > min2 & max1 < max2;
    }
}
