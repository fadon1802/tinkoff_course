package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class GameDictionary implements Dictionary {
    private final String[] words = {"car", "phone", "ball"};

    @Override
    public @NotNull String randomWord() {
        var index = new Random().nextInt(words.length);
        return words[index];
    }
}
