package edu.hw3;

import org.junit.jupiter.api.Test;

import static edu.hw3.Task4.convertToRoman;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void convertToRoman1() {
        assertEquals("II", convertToRoman(2));
    }

    @Test
    void convertToRoman2() {
        assertEquals("XII", convertToRoman(12));
    }
}
