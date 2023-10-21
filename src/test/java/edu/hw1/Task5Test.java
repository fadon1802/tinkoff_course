package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task5Test {

    @Test
    void isPalindromeDescendant1() {
        assertTrue(Task5.isPalindromeDescendant("11211230"));
    }

    @Test
    void isPalindromeDescendant2() {
        assertTrue(Task5.isPalindromeDescendant("13001120"));
    }

    @Test
    void isPalindromeDescendant3() {
        assertTrue(Task5.isPalindromeDescendant("23336014"));
    }

    @Test
    void isPalindromeDescendant4() {
        assertTrue(Task5.isPalindromeDescendant("11"));
    }

    @Test
    void isPalindromeDescendant5() {
        assertFalse(Task5.isPalindromeDescendant("12"));
    }

    @Test
    void isPalindromeDescendant6() {
        assertTrue(Task5.isPalindromeDescendant("121"));
    }

    @Test
    void isPalindromeDescendant7() {
        assertTrue(Task5.isPalindromeDescendant("5"));
    }
}
