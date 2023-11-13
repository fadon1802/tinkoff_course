package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @Test
    void getAverageDuration1() {
        assertEquals("3ч 40м", Task1.getAverageDuration("2022-03-12, 20:20 - 2022-03-12, 23:50\n"
            + "2022-04-01, 21:30 - 2022-04-02, 01:20"));
    }

    @Test
    void getAverageDuration2() {
        assertEquals("3ч 0м", Task1.getAverageDuration("""
                2022-03-12, 20:00 - 2022-03-13, 00:00
                2022-04-01, 19:30 - 2022-04-01, 21:30
                2022-04-05, 16:01 - 2022-04-05, 19:01"""));
    }
}
