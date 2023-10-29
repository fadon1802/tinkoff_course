package edu.hw2.Task3;

public final class PopularCommandExecutor {
    private ConnectionException cause;
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        var connection = manager.getConnection();
        var attempts = maxAttempts;
        while (true) {
            if (attempts == 0) {
                throw new ConnectionException(0, "number of attempts exceeded");
            }
            cause = null;
            try (connection) {
                connection.execute(command);
                return;
            } catch (ConnectionException exception) {
                cause = exception;
            }
            attempts = attempts - 1;
        }

    }
}
