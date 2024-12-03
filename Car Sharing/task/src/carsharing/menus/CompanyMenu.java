package carsharing.menus;

import carsharing.CarService;
import carsharing.Company;
import carsharing.util.Keyboard;

public class CompanyMenu {

    private final CarService carService;

    public CompanyMenu(CarService carService) {
        this.carService = carService;
    }

    public void show(Company company) {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("'" + company.name() + "' company");
            System.out.println("1. Car list");
            System.out.println("2. Create a car");
            System.out.println("0. Back");

            int choice = Keyboard.getInt();
            switch (choice) {
                case 1 -> carService.printAllForCompany(company.id());
                case 2 -> carService.createCar(company);
                case 0 -> keepGoing = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}