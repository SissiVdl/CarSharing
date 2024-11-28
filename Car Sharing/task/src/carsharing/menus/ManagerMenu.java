package carsharing.menus;

import carsharing.util.Keyboard;

public class ManagerMenu {
    public void show() {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("1. Company list");
            System.out.println("2. Create a company");
            System.out.println("0. Back");

            int choice = Keyboard.getInt();
            switch (choice) {
                case 1 -> System.out.println("1. Company list");
                case 2 -> System.out.println("2. Create a company");
                case 0 -> keepGoing = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
       }
    }
}
