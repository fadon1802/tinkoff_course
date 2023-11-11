package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Task1 {
    private static final int SECS_IN_MINUTE = 60;

    private Task1() {
    }

    public static String getAverageDuration(String input) {
        var dateTimesList = input.split("\n");
        var pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}), ([0-2]\\d:[0-5]\\d)");
        var durationSum = Duration.ZERO;
        for (var dateTimes : dateTimesList) {
            var dateTimeList = dateTimes.split(" - ");
            var startMatch = pattern.matcher(dateTimeList[0]);
            var endMatch = pattern.matcher(dateTimeList[1]);
            if (!startMatch.find() | !endMatch.find()) {
                throw new RuntimeException("Incorrect input");
            }

            var start = LocalDateTime.parse(startMatch.group(1) + "T" + startMatch.group(2));
            var end = LocalDateTime.parse(endMatch.group(1) + "T" + endMatch.group(2));
            durationSum = durationSum.plus(Duration.between(start, end));
        }

        Duration average = durationSum.dividedBy(dateTimesList.length);
        return String.format("%sч %sм", average.toHours(), average.toMinutes() % SECS_IN_MINUTE);
    }
}
