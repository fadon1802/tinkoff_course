package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final Random RANDOMIZER = new Random();

    @Override
    public Connection getConnection() {
        if (RANDOMIZER.nextInt(0, 3) == 0) {
            return new Connection.StableConnection();
        }
        return new Connection.FaultyConnection();
    }
}
