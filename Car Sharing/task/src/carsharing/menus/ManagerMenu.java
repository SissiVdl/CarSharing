package carsharing.menus;

import carsharing.util.Keyboard;

public class ManagerMenu {
    public void show() {
        System.out.println("1. Company list");
        System.out.println("2. Create a company");
        System.out.println("0. Back");

        handleChoice();
    }

    public void handleChoice() {
        int choice = Keyboard.getInt();
        switch (choice) {
            case 1 -> System.out.println("1. Company list");
            case 2 -> System.out.println("2. Create a company");
            case 0 -> System.out.println("0. Back");
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
