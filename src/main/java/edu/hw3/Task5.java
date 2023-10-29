package edu.hw3;

import java.util.Arrays;
import java.util.Comparator;

public class Task5 {
    private Task5() {
    }

    public static String[] parseContacts(String[] names, String order) {
        if (names == null || names.length == 0) {
            return new String[0];
        }


        var result = Arrays.stream(names).sorted((ln1, ln2) -> String.CASE_INSENSITIVE_ORDER.compare(
            ln1.split(" ").length > 1 ? ln1.split(" ")[1] : ln1,
            ln2.split(" ").length > 1 ? ln2.split(" ")[1] : ln2
        ));
        if (order.equals("DESC")) {
            result = result.sorted(Comparator.reverseOrder());
        }

        return result.toList().toArray(new String[0]);
    }
}
