package carsharing.menus;

import carsharing.Company;
import carsharing.util.Keyboard;

import java.sql.SQLOutput;

public class CompanyMenu {

    public static void show(Company company) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("1. Car list");
            System.out.println("2. Create a car");
            System.out.println("0. Back");

            int choice = Keyboard.getInt();
            switch (choice) {
                case 1 -> System.out.println("1 - to be implemented");
                case 2 -> System.out.println("2 - to be implemented");
                case 0 -> keepGoing = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
