package edu.hw1;

import java.util.Arrays;
import java.util.OptionalInt;

public class Task3 {
    private Task3() {
    }

    private static OptionalInt getMin(int[] array) {
        return Arrays.stream(array).min();
    }

    private static OptionalInt getMax(int[] array) {
        return Arrays.stream(array).max();
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        if (getMin(a1).isEmpty() | getMax(a1).isEmpty()) {
            return false;
        }

        if (getMin(a2).isEmpty() | getMax(a2).isEmpty()) {
            return false;
        }

        int min1 = getMin(a1).getAsInt();
        int max1 = getMax(a1).getAsInt();
        int min2 = getMin(a2).getAsInt();
        int max2 = getMax(a2).getAsInt();

        return min1 > min2 & max1 < max2;
    }
}
