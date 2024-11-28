package carsharing.util;

import java.util.Scanner;

public class Keyboard {
    private static final Scanner KEYBOARD = new Scanner(System.in);

    private Keyboard() {}

    public static String getNextLine() {
        return KEYBOARD.nextLine();
    }

    public static String getNextLine(String message) {
        System.out.println(message);
        return getNextLine();
    }

    public static int getInt() {
        return Integer.parseInt(KEYBOARD.nextLine());
    }

    public static int getInt(String message) {
        System.out.println(message);
        return getInt();
    }

    public static double getDouble() {
        return Double.parseDouble(KEYBOARD.nextLine());
    }

    public static double getDouble(String message) {
        System.out.println(message);
        return getDouble();
    }
}
