package edu.hw2.Task3;

import java.util.Random;

public sealed interface Connection extends AutoCloseable {
    void execute(String command);

    final class FaultyConnection implements Connection {
        private final static Random RANDOMIZER = new Random();

        @Override
        public void execute(String command) {
            if (RANDOMIZER.nextInt(0, 2) == 0){
                throw new ConnectionException(1, "bad execute");
            }
        }

        @Override
        public void close() {
        }
    }

    final class StableConnection implements Connection {

        @Override
        public void execute(String command) {
        }

        @Override
        public void close() {
        }
    }
}

