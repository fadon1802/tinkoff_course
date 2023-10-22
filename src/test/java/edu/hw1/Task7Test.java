package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task7Test {

    @Test
    void rotateRight1() {
        assertEquals(4, Task7.rotateRight(8, 1));
    }

    @Test
    void rotateRight2() {
        assertEquals(8, Task7.rotateRight(8, 32), "Should work with big shift");
    }

    @Test
    void rotateLeft1() {
        assertEquals(1, Task7.rotateLeft(16, 1));
    }

    @Test
    void rotateLeft2() {
        assertEquals(6, Task7.rotateLeft(17, 2));
    }

    @Test
    void rotateLeft3() {
        assertEquals(1, Task7.rotateLeft(16, 26), "Should work with big shift");
    }
}
