package edu.hw1;

import java.util.Arrays;
import java.util.stream.Stream;

public class Task7 {
    private Task7() {
    }

    public static int rotateRight(int n, int shift) {
        var byteN = Integer.toBinaryString(n);
        var newShift = byteN.length() - shift;
        return rotateLeft(n, newShift);
    }

    public static int rotateLeft(int n, int shift) {
        var byteN = Integer.toBinaryString(n);
        var newShift = shift % byteN.length();
        var byteArray = byteN.split("");
        var rr = Stream.concat(
            Arrays.stream(byteArray).skip(newShift),
            Arrays.stream(byteArray).limit(newShift)
        ).toList();
        return Integer.parseInt(String.join("", rr), 2);
    }
}
