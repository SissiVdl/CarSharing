package carsharing.menus;

import carsharing.*;
import carsharing.util.Keyboard;

import java.util.List;

public class ManagerMenu {

    private final CompanyService companyService;
    private final CarService carService;

    public ManagerMenu(DbCompanyDAO companyDAO, DbCarDAO carDAO) {
        this.companyService = new CompanyService(companyDAO);
        this.carService = new CarService(carDAO);
    }
    
    public void show() {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("1. Company list");
            System.out.println("2. Create a company");
            System.out.println("0. Back");

            int choice = Keyboard.getInt();
            switch (choice) {
                case 1 -> new CompanyMenu(carService).show(companyService.chooseCompany());
                case 2 -> companyService.createCompany();
                case 0 -> keepGoing = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
       }
    }
}
