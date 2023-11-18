package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class ParserSlash extends Parser {
    public ParserSlash(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public Optional<LocalDate> parseDate(String date) {
        LocalDate parsed;
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("d/M/yyyy");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("d/M/yy");
        try {
            parsed = LocalDate.parse(date, f1);
        } catch (DateTimeParseException notFirst) {
            try {
                parsed = LocalDate.parse(date, f2);
            } catch (DateTimeParseException notSecond) {
                if (nextParser != null) {
                    return nextParser.parseDate(date);
                }

                return Optional.empty();
            }
        }

        return Optional.of(parsed);
    }
}
