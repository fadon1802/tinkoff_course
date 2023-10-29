package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static edu.hw3.Task2.clusterize;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void clusterize1() {
        assertEquals(Arrays.asList("()", "()", "()"), clusterize("()()()"));
    }

    @Test
    void clusterize2() {
        assertEquals(Arrays.asList("((()))"), clusterize("((()))"));
    }

    @Test
    void clusterize3() {
        assertEquals(Arrays.asList("((()))", "(())", "()", "()", "(()())"), clusterize("((()))(())()()(()())"));
    }
}
