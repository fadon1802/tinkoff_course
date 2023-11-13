package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class ParserNormal extends Parser {

    public ParserNormal(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public Optional<LocalDate> parseDate(String date) {
        LocalDate parsed;
        try {
            parsed = LocalDate.parse(date);
        } catch (DateTimeParseException exception) {
            return nextParser.parseDate(date);
        }

        return Optional.of(parsed);
    }
}
