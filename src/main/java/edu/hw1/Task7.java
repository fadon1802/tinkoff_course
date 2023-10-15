package edu.hw1;

import java.util.Arrays;
import java.util.stream.Stream;

public class Task7 {
    public static int rotateRight(int n, int shift) {
        var byteN = Integer.toBinaryString(n);
        shift = shift % byteN.length();
        var byteArray = byteN.split("");
        var rr = Stream.concat(
            Arrays.stream(byteArray).skip(byteN.length() - shift),
            Arrays.stream(byteArray).limit(byteN.length() - shift)
        ).toList();
        return Integer.parseInt(String.join("", rr), 2);
    }

    public static int rotateLeft(int n, int shift) {
        var byteN = Integer.toBinaryString(n);
        shift = shift % byteN.length();
        var byteArray = byteN.split("");
        var rr = Stream.concat(Arrays.stream(byteArray).skip(shift), Arrays.stream(byteArray).limit(shift)).toList();
        return Integer.parseInt(String.join("", rr), 2);
    }
}
