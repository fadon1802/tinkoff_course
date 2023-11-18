package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class ParserNormal extends Parser {

    public ParserNormal(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public Optional<LocalDate> parseDate(String date) {
        LocalDate parsed;
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-d");
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
