package edu.hw1;

public class Task1 {
    private Task1() {
    }

    private static final int MINUTE_TO_SECONDS = 60;

    public static int minutesToSeconds(String timeStr) {
        String[] minutesSeconds = timeStr.split(":");
        var seconds1 = Integer.parseInt(minutesSeconds[0]) * MINUTE_TO_SECONDS;
        var seconds2 = Integer.parseInt(minutesSeconds[1]);
        if (seconds2 >= MINUTE_TO_SECONDS) {
            return -1;
        }
        return seconds1 + seconds2;
    }
}
