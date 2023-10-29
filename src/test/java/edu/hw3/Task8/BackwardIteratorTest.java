package edu.hw3.Task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackwardIteratorTest {

    @Test
    void iteratorTest() {
        var it = new BackwardIterator<>(Arrays.asList(1, 2, 3));
        var result = new ArrayList<>();
        while (it.hasNext()) {
            result.add(it.next());
        }

        assertEquals(List.of(3, 2, 1), result);
    }
}
