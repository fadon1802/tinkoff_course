package edu.project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleHangmanTest {

    @Test
    void incorrectLength1() {
        assertThrows(RuntimeException.class, () -> new ConsoleHangman(new Session("", 3)));
    }

    @Test
    void incorrectLength2() {
        assertThrows(RuntimeException.class, () -> new ConsoleHangman(new Session(" ", 3)));
    }

    @Test
    void ranOutOfAttempts1() {
        var ch = new ConsoleHangman(new Session("word", 1));
        ch.run(new char[] {'a'});
        assertSame(GuessResult.Defeat.class, ch.getFirstGameState().getClass());
    }

    @Test
    void successfulGuess() {
        var ch = new ConsoleHangman(new Session("word", 1));
        ch.run(new char[] {'w', ' '});
        assertSame(GuessResult.SuccessfulGuess.class, ch.getFirstGameState().getClass());
    }
}
