package edu.hw2.Task3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PopularCommandExecutorTest {

    @Test
    void updatePackages() {
        var executor = new PopularCommandExecutor(new DefaultConnectionManager(), 0);
        ConnectionException exception = assertThrows(ConnectionException.class, executor::updatePackages);
        assertEquals("Exception: number of attempts exceeded. Code: 0", exception.getMessage());
    }
}
