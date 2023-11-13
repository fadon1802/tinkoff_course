package edu.hw5;

import java.time.LocalDate;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        System.out.println(Task2.getNextFriday13("1925-05-21"));
        System.out.println(Task4.hasSpecificSymbol("dfdd^fdyhyf"));


        System.out.println(LocalDate.parse("2023-10-1"));
    }
}
