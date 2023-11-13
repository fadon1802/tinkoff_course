package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

class Task7Test {

    @Test
    void firstRegexTest1() {
        var pattern = Pattern.compile(Task7.REGEX1);
        var matcher = pattern.matcher("010");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void firstRegexTest2() {
        var pattern = Pattern.compile(Task7.REGEX1);
        var matcher = pattern.matcher("011");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void firstRegexTest3() {
        var pattern = Pattern.compile(Task7.REGEX1);
        var matcher = pattern.matcher("01");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void firstRegexTest4() {
        var pattern = Pattern.compile(Task7.REGEX1);
        var matcher = pattern.matcher("0010");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void firstRegexTest5() {
        var pattern = Pattern.compile(Task7.REGEX1);
        var matcher = pattern.matcher("1122");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void secondRegexTest1() {
        var pattern = Pattern.compile(Task7.REGEX2);
        var matcher = pattern.matcher("1");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void secondRegexTest2() {
        var pattern = Pattern.compile(Task7.REGEX2);
        var matcher = pattern.matcher("0");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void secondRegexTest3() {
        var pattern = Pattern.compile(Task7.REGEX2);
        var matcher = pattern.matcher("11");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void secondRegexTest4() {
        var pattern = Pattern.compile(Task7.REGEX2);
        var matcher = pattern.matcher("110101010101");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void secondRegexTest5() {
        var pattern = Pattern.compile(Task7.REGEX2);
        var matcher = pattern.matcher("01");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void secondRegexTest6() {
        var pattern = Pattern.compile(Task7.REGEX2);
        var matcher = pattern.matcher("1211");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void thirdRegexTest1() {
        var pattern = Pattern.compile(Task7.REGEX3);
        var matcher = pattern.matcher("1");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void thirdRegexTest2() {
        var pattern = Pattern.compile(Task7.REGEX3);
        var matcher = pattern.matcher("100");
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void thirdRegexTest3() {
        var pattern = Pattern.compile(Task7.REGEX3);
        var matcher = pattern.matcher("12");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void thirdRegexTest4() {
        var pattern = Pattern.compile(Task7.REGEX3);
        var matcher = pattern.matcher("1111");
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void thirdRegexTest5() {
        var pattern = Pattern.compile(Task7.REGEX3);
        var matcher = pattern.matcher("");
        Assertions.assertFalse(matcher.matches());
    }
}
