package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static edu.hw3.Task3.frequencyDict;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void frequencyDict1() {
        assertEquals(Map.of("a", 2, "bb", 2), frequencyDict(new String[]{"a", "bb", "a", "bb"}));
    }

    @Test
    void frequencyDict2() {
        assertEquals(Map.of("that", 1, "and", 2, "this", 1), frequencyDict(new String[]{"this", "and", "that", "and"}));
    }
}
