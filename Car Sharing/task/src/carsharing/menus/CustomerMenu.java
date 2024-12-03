package carsharing.menus;

import carsharing.services.CustomerService;

public class CustomerMenu {

    private final CustomerService customerService;
    private final MainMenu mainMenu;

    public CustomerMenu(CustomerService customerService, MainMenu mainMenu) {
        this.customerService = customerService;
        this.mainMenu = mainMenu;
    }

    public void show() {
        System.out.println("1. Rent a car");
        System.out.println("2. My rented car");
        System.out.println("3. Return a rented car");
        System.out.println("0. Back");

        handleChoice();
    }

    public void handleChoice() {
        int choice = carsharing.util.Keyboard.getInt();
        switch (choice) {
            case 1 -> System.out.println("customerService.rentCar()");
            case 2 -> System.out.println("customerService.myRentedCar()");
            case 3 -> System.out.println("customerService.returnRentedCar()");
            case 0 -> mainMenu.show();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
