package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private static final int DAYS_IN_WEEK = 7;

    private Task2() {
    }

    @SuppressWarnings("MagicNumber")
    public static List<String> getFridays13th(int year) {
        var fridays13th = new ArrayList<String>();
        var date = LocalDate.of(year, Month.JANUARY, 1);
        while (date.getDayOfWeek() != DayOfWeek.FRIDAY) {
            date = date.plusDays(1);
        }

        while (date.getYear() == year) {
            if (date.getDayOfMonth() == 13 && date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays13th.add(date.toString());
            }

            date = date.plusDays(DAYS_IN_WEEK);
        }

        return fridays13th;
    }

    @SuppressWarnings("MagicNumber")
    public static String getNextFriday13(String date) {
        var localDate = LocalDate.parse(date);
        TemporalAdjuster adjuster = t -> {
            while (t.get(ChronoField.DAY_OF_WEEK) != 5
                || t.get(ChronoField.DAY_OF_MONTH) != 13) {
                t = t.plus(1, ChronoUnit.DAYS);
            }

            return t;
        };

        return localDate.with(adjuster).toString();
    }
}
