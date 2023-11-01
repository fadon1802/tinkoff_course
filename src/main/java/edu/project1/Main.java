package edu.project1;

public class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        var dict = new GameDictionary();
        var ch = new ConsoleHangman(new Session(dict.randomWord(), 1));
        ch.run(null);
    }
}
