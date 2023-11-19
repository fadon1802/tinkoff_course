package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CloneFile {
    private CloneFile() {
    }

    @SuppressWarnings({"MultipleStringLiterals"})
    public static Path cloneFile(Path path) throws IOException {
        var name = path.toString();
        var regexFirstCopy = "^.* - копия\\..*$";
        var regexOtherCopy = "^.* - копия \\((\\d+)\\)\\..*$";
        var patternOther = Pattern.compile(regexOtherCopy);
        Matcher otherCopy = patternOther.matcher(name);

        if (Files.exists(path)) {
            if (name.matches(regexFirstCopy)) {
                var parts = name.split("\\.");
                var copy = Path.of(parts[0] + " (1)." + parts[1]);
                Files.copy(path, copy);
                return Files.copy(path, copy);
            } else if (otherCopy.matches()) {
                var nextCount = Integer.parseInt(otherCopy.group(1)) + 1;
                var parts = name.split("\\(\\d+\\)");
                var result = String.join(String.format("(%s)", nextCount), parts);
                return Files.copy(path, Path.of(result));
            } else {
                var parts = path.toString().split("\\.");
                var result = parts[0] + " - копия." + parts[1];
                return Files.copy(path, Path.of(result));
            }
        }

        return Files.createFile(path);
    }
}
