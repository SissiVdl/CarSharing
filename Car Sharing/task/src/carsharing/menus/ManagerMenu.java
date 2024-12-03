package carsharing.menus;

import carsharing.services.CarService;
import carsharing.services.CompanyService;
import carsharing.util.Keyboard;

public class ManagerMenu {

    private final CompanyService companyService;
    private final CarService carService;

    private final MainMenu mainMenu;

    public ManagerMenu(CompanyService companyService, CarService carService, MainMenu mainMenu) {
        this.companyService = companyService;
        this.carService = carService;
        this.mainMenu = mainMenu;
    }

    public void show() {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("1. Company list");
            System.out.println("2. Create a company");
            System.out.println("0. Back");

            keepGoing = handleChoice();
        }
    }

    private boolean handleChoice() {
        int choice = Keyboard.getInt();
        switch (choice) {
            case 1 -> new CompanyMenu(carService, companyService).show();
            case 2 -> companyService.createCompany();
            case 0 -> {
                mainMenu.show();
                return false;
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        return true;
    }
}