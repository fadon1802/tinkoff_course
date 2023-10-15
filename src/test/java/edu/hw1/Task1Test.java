package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {

    @Test
    void minutesToSeconds1() {
        Assertions.assertEquals(Task1.minutesToSeconds("02:10"), 130, "must be correct counted");
    }

    @Test
    void minutesToSeconds2() {
        Assertions.assertEquals(Task1.minutesToSeconds("13:56"), 836, "must be correct counted");
    }

    @Test
    void minutesToSeconds3() {
        Assertions.assertEquals(Task1.minutesToSeconds("10:60"), -1, "must work with incorrect time");
    }

    @Test
    void minutesToSeconds4() {
        Assertions.assertEquals(Task1.minutesToSeconds("01:00"), 60, "must work with zero secs");
    }

    @Test
    void minutesToSeconds5() {
        Assertions.assertEquals(Task1.minutesToSeconds("00:59"), 59, "must work with zero minutes");
    }
}
