package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void hasSpecificSymbol1() {
        assertTrue(Task4.hasSpecificSymbol("dfdfd#LDFLF"));
    }

    @Test
    void hasSpecificSymbol2() {
        assertFalse(Task4.hasSpecificSymbol("dfdfdLDFLF123"));
    }
}
