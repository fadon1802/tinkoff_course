package edu.hw5;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        System.out.println(Task1.getAverageDuration("2022-03-12, 20:20 - 2022-03-12, 23:50\n" +
            "2022-04-01, 21:30 - 2022-04-02, 01:20"));
        System.out.println(Task2.getFridays13th(1925));
    }
}
