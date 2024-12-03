package carsharing.menus;

import carsharing.services.CarService;
import carsharing.domain.Company;
import carsharing.services.CompanyService;
import carsharing.util.Keyboard;

import java.util.List;

public class CompanyMenu {
    private final CarService carService;
    private final CompanyService companyService;

    public CompanyMenu(CarService carService, CompanyService companyService) {
        this.carService = carService;
        this.companyService = companyService;
    }

    public void show() {
        List<Company> companies = companyService.displayCompanies();
        if (companies.isEmpty()) {
            return;
        }
        handleChoice();
    }

    private void handleChoice() {
        int choice = Keyboard.getInt();
        if (choice == 0) {
            return;
        }
        Company company = companyService.getCompanyById(choice);
        if (company != null) {
            showCompanyOptions(company);
        } else {
            System.out.println("There is no company with this ID!");
        }
    }

    private void showCompanyOptions(Company company) {
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