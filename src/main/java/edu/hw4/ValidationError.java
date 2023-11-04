package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public record ValidationError(String error) {
    public static List<ValidationError> validateName(String name) {
        var errorList = new ArrayList<ValidationError>();

        if (name.isEmpty()) {
            errorList.add(new ValidationError("Name is empty"));
        } else if (Character.isLowerCase(name.charAt(0))) {
            errorList.add(new ValidationError("Name does not start with uppercase"));
        }

        return errorList;
    }
}
