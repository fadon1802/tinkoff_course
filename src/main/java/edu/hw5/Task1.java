package edu.hw5;

import java.time.*;
import java.util.regex.Pattern;

public class Task1 {
    public static String getAverageDuration(String input) {
        var dateTimesList = input.split("\n");
        var pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}), ([0-2]\\d:[0-5]\\d)");
        long durationSum = 0;
        for (var dateTimes : dateTimesList) {
            var dateTimeList = dateTimes.split(" - ");
            var startMatch = pattern.matcher(dateTimeList[0]);
            var endMatch = pattern.matcher(dateTimeList[1]);
            if (!startMatch.find() | !endMatch.find()) {
                throw new RuntimeException("Incorrect input");
            }
            var start = LocalDateTime.parse(startMatch.group(1) + "T" + startMatch.group(2) + ":00");
            var end = LocalDateTime.parse(endMatch.group(1) + "T" + endMatch.group(2) + ":00");
            durationSum += Duration.between(start, end).getSeconds();
        }

        long avgDurationInSecs = durationSum / dateTimesList.length;
        Duration avgDuration = Duration.ofSeconds(avgDurationInSecs);
        return String.format("%sч %sм", avgDuration.toHours(), avgDuration.toMinutes() % 60);
    }
}
