package edu.hw3.Task7;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NullComparatorTest {

    @Test
    void compare1() {
        var tree = new TreeMap<String, String>(new NullComparator());
        tree.put(null, "test");
        assertTrue(tree.containsKey(null));
    }

    @Test
    void compare2() {
        var tree = new TreeMap<String, String>(new NullComparator());
        tree.put("c", "test");
        tree.put("a", "test");
        tree.put("b", "test");
        assertEquals("a", tree.keySet().toArray(new String[0])[0]);
    }
}
