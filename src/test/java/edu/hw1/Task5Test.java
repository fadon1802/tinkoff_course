package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void isPalindromeDescendant() {
        Assertions.assertEquals(Task5.isPalindromeDescendant(11211230), true);
    }

    @Test
    void isPalindromeDescendant1() {
        Assertions.assertEquals(Task5.isPalindromeDescendant(13001120), true);
    }

    @Test
    void isPalindromeDescendant2() {
        Assertions.assertEquals(Task5.isPalindromeDescendant(23336014), true);
    }

    @Test
    void isPalindromeDescendant3() {
        Assertions.assertEquals(Task5.isPalindromeDescendant(11), true);
    }
}
