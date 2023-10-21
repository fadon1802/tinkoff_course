package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4Test {

    @Test
    void fixString() {
        assertEquals("214365", Task4.fixString("123456"));
    }

    @Test
    void fixString1() {
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    void fixString2() {
        assertEquals("abcde", Task4.fixString("badce"));
    }
}
