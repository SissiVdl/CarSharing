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
                case 1 -> showCompanyList();
                case 2 -> companyService.createCompany();
                case 0 -> keepGoing = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    private void showCompanyList() {
        List<Company> companies = companyService.getAllCompanies();
        if (companies.isEmpty()) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println("Choose a company:");
            companies.forEach(comp -> System.out.println(comp.id() + ". " + comp.name()));
            System.out.println("0. Back");
            int choice = Keyboard.getInt();

            if (choice == 0) {
                return;
            }
            Company company = companyService.getCompanyById(choice);
            if (company != null) {
                new CompanyMenu(carService).show(company);
            } else {
                System.out.println("There is no company with this ID!");
            }
        }
    }
}