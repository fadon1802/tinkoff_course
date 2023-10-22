package edu.hw2.Task4;

import org.junit.jupiter.api.Test;
import static edu.hw2.Task4.Calling.callingInfo;
import static org.junit.jupiter.api.Assertions.*;

class CallingTest {

    @Test
    void callingInfo1() {
        CallingInfo info = callingInfo();
        assertEquals("edu.hw2.Task4.Calling", info.className());
    }

    @Test
    void callingInfo2() {
        CallingInfo info = callingInfo();
        assertEquals("callingInfo", info.methodName());
    }
}
