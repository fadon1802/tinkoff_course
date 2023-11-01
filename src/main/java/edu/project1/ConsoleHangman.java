package edu.project1;

import java.util.Scanner;
import org.jetbrains.annotations.Nullable;
import static java.lang.System.out;

public class ConsoleHangman {

    private final Session session;
    private GuessResult firstGameState;

    public ConsoleHangman(Session session) {
        this.session = session;
    }

    public void run(char @Nullable [] userInput) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (true) {
            out.println("Guess a letter:");
            GuessResult res;
            if (userInput != null && userInput.length != 0) {
                res = tryGuess(session, String.valueOf(userInput[i++]));
            } else {
                res = tryGuess(session, in.nextLine());
            }

            if (res == null) {
                continue;
            }
            out.println("The word: " + String.join("", new String(res.state())));
            printState(res);
            if (firstGameState == null) {
                firstGameState = res;
            }

            if (res.getClass() == GuessResult.Win.class || res.getClass() == GuessResult.Defeat.class) {
                break;
            }
        }

        in.close();
    }

    private GuessResult tryGuess(Session session, String guess) {
        if (guess.length() != 1) {
            return null;
        }

        return session.guess(guess);
    }

    private void printState(GuessResult guessResult) {
        out.println(guessResult.message());
    }

    public GuessResult getFirstGameState() {
        return firstGameState;
    }
}
