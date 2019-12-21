package io.dodev.java.seria.util;

import java.io.IOException;

public class ConsoleIO {
    public static void cls() throws IOException {
        char ESC = (char)27;
        System.out.print(ESC + "[2J");
        System.out.print(ESC + "[H");
    }
}
