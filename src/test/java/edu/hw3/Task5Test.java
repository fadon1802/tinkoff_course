package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task5.parseContacts;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task5Test {

    @Test
    void parseContacts1() {
        assertArrayEquals(
            new String[] {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"},
            parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC")
        );
    }
}
