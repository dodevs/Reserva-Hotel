package io.dodev.java.seria.util;

public class ConsoleIO {
    public static void cls() {
        char ESC = (char)27;
        System.out.print(ESC + "[2J");
        System.out.print(ESC + "[H");
    }
}
