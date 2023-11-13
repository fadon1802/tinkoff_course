package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void isSubstring1() {
        var subString = "abc";
        var string = "achfdbaabgabcaabg";
        assertTrue(Task6.isSubstring(string, subString));
    }

    @Test
    void isSubstring2() {
        var subString = "abc";
        var string = "abc";
        assertTrue(Task6.isSubstring(string, subString));
    }

    @Test
    void isSubstring3() {
        var subString = "aecfhcdabdc";
        var string = "abc";
        assertFalse(Task6.isSubstring(string, subString));
    }
}
