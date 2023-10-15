package edu.hw1;

public class Task1 {
    public static int minutesToSeconds(String timeStr) {
        String[] minutesSeconds = timeStr.split(":");
        var seconds1 = Integer.parseInt(minutesSeconds[0]) * 60;
        var seconds2 = Integer.parseInt(minutesSeconds[1]);
        if (seconds2 >= 60) {
            return -1;
        }
        return seconds1 + seconds2;
    }
}
