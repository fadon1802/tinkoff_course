package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.Period;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParsersTest {
    static ParserNormal normalParser;

    @BeforeAll
    static void setParsers() {
        normalParser = new ParserNormal(new ParserSlash(new ParserWord(new ParserSentence(null))));
    }

    @Test
    void parseNormalTest1() {
        assertEquals("2020-10-10", normalParser.parseDate("2020-10-10").get().toString());
    }

    @Test
    void parseNormalTest2() {
        assertEquals("2020-12-02", normalParser.parseDate("2020-12-2").get().toString());
    }

    @Test
    void parseSlashTest3() {
        assertEquals("1976-03-01", normalParser.parseDate("1/3/1976").get().toString());
    }

    @Test
    void parseSlashTest4() {
        assertEquals("2020-03-01", normalParser.parseDate("1/3/20").get().toString());
    }

    @Test
    void parseWordTest5() {
        assertEquals(LocalDate.now().plus(Period.ofDays(1)), normalParser.parseDate("tomorrow").get());
    }

    @Test
    void parseWordTest6() {
        assertEquals(LocalDate.now(), normalParser.parseDate("today").get());
    }

    @Test
    void parseWordTest7() {
        assertEquals(LocalDate.now().minus(Period.ofDays(1)), normalParser.parseDate("yesterday").get());
    }

    @Test
    void parseSentenceTest8() {
        assertEquals(LocalDate.now().minus(Period.ofDays(1)), normalParser.parseDate("1 day ago").get());
    }

    @Test
    void parseSentenceTest9() {
        assertEquals(LocalDate.now().minus(Period.ofDays(10)), normalParser.parseDate("10 days ago").get());
    }
}
