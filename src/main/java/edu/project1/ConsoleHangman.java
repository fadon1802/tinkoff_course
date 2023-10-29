package edu.project1;

import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.out;

public class ConsoleHangman {

    private final Session session;

    public ConsoleHangman(Session session) {
        this.session = session;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        while (true) {
            out.println("Guess a letter:");
            var res = tryGuess(session, in.nextLine());
            if (res == null) {
                continue;
            }
            printState(res);
            if (res.getClass() == GuessResult.Win.class || res.getClass() == GuessResult.Defeat.class) {
                break;
            }
            out.println("The word: " + new String(session.getUserAnswer()));
        }

        in.close();
    }

    private GuessResult tryGuess(Session session, String input) {
        if (input.length() != 1) {
            return null;
        }
        try {
            return session.guess(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void printState(GuessResult guessResult) {
        out.println(guessResult.message());
    }
}
