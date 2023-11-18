package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.regex.Pattern;

public class ParserSentence extends Parser {
    public ParserSentence(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public Optional<LocalDate> parseDate(String date) {
        LocalDate parsed;
        var regex1 = "^\\d day ago$";
        var regex2 = "^(\\d+) days ago$";

        if (date.matches(regex1)) {
            parsed = LocalDate.now().minus(Period.ofDays(Integer.parseInt(String.valueOf(date.charAt(0)))));
            return Optional.of(parsed);
        }

        var pattern = Pattern.compile(regex2);
        var matcher = pattern.matcher(date);

        if (matcher.matches()) {
            var daysAmount = Integer.parseInt(matcher.group(1));
            parsed = LocalDate.now().minus(Period.ofDays(daysAmount));
            return Optional.of(parsed);
        }

        if (nextParser != null) {
            return nextParser.parseDate(date);
        }

        return Optional.empty();
    }
}
