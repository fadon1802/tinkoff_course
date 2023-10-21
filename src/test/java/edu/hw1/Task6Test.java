package edu.hw1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Task6Test {

    @Test
    void countK1() {
        assertEquals(5, Task6.countK("6621"));
    }

    @Test
    void countK2() {
        assertEquals(4, Task6.countK("6554"));
    }

    @Test
    void countK3() {
        assertEquals(3, Task6.countK("1234"));
    }
}
