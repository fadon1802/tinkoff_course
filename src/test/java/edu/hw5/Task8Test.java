package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

class Task8Test {

    @Test
    void regex1Test1() {
        var pattern = Pattern.compile(Task8.REGEX1);
        var matcher = pattern.matcher("10010111101");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void regex1Test2() {
        var pattern = Pattern.compile(Task8.REGEX1);
        var matcher = pattern.matcher("100101111010");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void regex2Test1() {
        var pattern = Pattern.compile(Task8.REGEX2);
        var matcher = pattern.matcher("001110");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void regex2Test2() {
        var pattern = Pattern.compile(Task8.REGEX2);
        var matcher = pattern.matcher("11110");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void regex3Test1() {
        var pattern = Pattern.compile(Task8.REGEX3);
        var matcher = pattern.matcher("000");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void regex3Test2() {
        var pattern = Pattern.compile(Task8.REGEX3);
        var matcher = pattern.matcher("0001");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void regex3Test3() {
        var pattern = Pattern.compile(Task8.REGEX3);
        var matcher = pattern.matcher("001101110001");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void regex3Test4() {
        var pattern = Pattern.compile(Task8.REGEX3);
        var matcher = pattern.matcher("001101110011111");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void regex5Test1() {
        var pattern = Pattern.compile(Task8.REGEX5);
        var matcher = pattern.matcher("1");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void regex5Test2() {
        var pattern = Pattern.compile(Task8.REGEX5);
        var matcher = pattern.matcher("1111111");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void regex5Test3() {
        var pattern = Pattern.compile(Task8.REGEX5);
        var matcher = pattern.matcher("1010101010");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void regex5Test4() {
        var pattern = Pattern.compile(Task8.REGEX5);
        var matcher = pattern.matcher("101011111");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void regex5Test5() {
        var pattern = Pattern.compile(Task8.REGEX5);
        var matcher = pattern.matcher("1011100000");
        Assertions.assertFalse(matcher.matches());
    }
}
