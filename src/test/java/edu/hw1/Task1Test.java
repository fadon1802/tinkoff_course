package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @Test
    void minutesToSeconds1() {
        assertEquals(130, Task1.minutesToSeconds("02:10"), "must be correct counted");
    }

    @Test
    void minutesToSeconds2() {
        assertEquals(836, Task1.minutesToSeconds("13:56"), "must be correct counted");
    }

    @Test
    void minutesToSeconds3() {
        assertEquals(-1, Task1.minutesToSeconds("10:60"), "must work with incorrect time");
    }

    @Test
    void minutesToSeconds4() {
        assertEquals(60, Task1.minutesToSeconds("01:00"), "must work with zero secs");
    }

    @Test
    void minutesToSeconds5() {
        assertEquals(59, Task1.minutesToSeconds("00:59"), "must work with zero minutes");
    }
}
