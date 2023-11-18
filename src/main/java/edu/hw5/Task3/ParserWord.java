package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class ParserWord extends Parser {
    public ParserWord(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public Optional<LocalDate> parseDate(String date) {
        Period period = switch (date) {
            case "tomorrow" -> Period.ofDays(1);
            case "today" -> Period.ZERO;
            case "yesterday" -> Period.ofDays(-1);
            default -> null;
        };

        if (period != null) {
            LocalDate parsed = LocalDate.now().plus(period);
            return Optional.of(parsed);
        }

        if (nextParser != null) {
            return nextParser.parseDate(date);
        }

        return Optional.empty();
    }
}
