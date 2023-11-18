package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void isValidLicensePlate1() {
        assertTrue(Task5.isValidLicensePlate("А123ВХ312"));
    }

    @Test
    void isValidLicensePlate2() {
        assertTrue(Task5.isValidLicensePlate("О777ОО177"));
    }

    @Test
    void isValidLicensePlate3() {
        assertFalse(Task5.isValidLicensePlate("123АВЕ777"));
    }

    @Test
    void isValidLicensePlate4() {
        assertFalse(Task5.isValidLicensePlate("А123ВГ77"));
    }

    @Test
    void isValidLicensePlate5() {
        assertFalse(Task5.isValidLicensePlate("А123ВЕ7777"));
    }
}
