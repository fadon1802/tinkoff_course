package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {
    @Test
    void countDigits1() {
        Assertions.assertEquals(4, Task2.countDigits(4666));
    }

    @Test
    void countDigits2() {
        Assertions.assertEquals(3, Task2.countDigits(544));
    }

    @Test
    void countDigits3() {
        Assertions.assertEquals(1, Task2.countDigits(0));
    }

    @Test
    void countDigits4() {
        Assertions.assertEquals(2, Task2.countDigits(99));
    }

    @Test
    void countDigits5() {
        Assertions.assertEquals(1, Task2.countDigits(1));
    }

    @Test
    void countDigits6() {
        Assertions.assertEquals(2, Task2.countDigits(-10));
    }
}
