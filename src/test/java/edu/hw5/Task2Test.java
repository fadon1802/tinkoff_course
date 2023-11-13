package edu.hw5;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

    @Test
    void getFridays13thTest1() {
        assertEquals(List.of("1925-02-13", "1925-03-13", "1925-11-13"), Task2.getFridays13th(1925));
    }

    @Test
    void getFridays13thTest2() {
        assertEquals(List.of("2024-09-13", "2024-12-13"), Task2.getFridays13th(2024));
    }

    @Test
    void getNextFriday13() {
        assertEquals("2023-10-13", Task2.getNextFriday13("2023-09-01"));
    }
}
