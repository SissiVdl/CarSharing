package carsharing.menus;

import carsharing.Company;
import carsharing.CompanyService;
import carsharing.DbCompanyDAO;
import carsharing.util.Keyboard;

import java.util.List;

public class ManagerMenu {

    private final CompanyService companyService;

    public ManagerMenu(DbCompanyDAO companyDAO) {

        this.companyService = new CompanyService(companyDAO);
    }
    
    public void show() {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("1. Company list");
            System.out.println("2. Create a company");
            System.out.println("0. Back");

            int choice = Keyboard.getInt();
            switch (choice) {
                case 1 -> companyService.printCompanyList();
                case 2 -> createCompany();
                case 0 -> keepGoing = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
       }
    }

    public void createCompany() {
        System.out.println("Enter the company name:");
        String name = Keyboard.getNextLine();
        Company company = new Company(0, name);
        DbCompanyDAO dbCompanyDAO = new DbCompanyDAO();
        dbCompanyDAO.add(company);
        System.out.println("The company was created!");
    }
}
