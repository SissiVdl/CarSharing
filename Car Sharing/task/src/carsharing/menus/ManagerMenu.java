package carsharing.menus;

import carsharing.Company;
import carsharing.DbCompanyDAO;
import carsharing.util.Keyboard;

import java.util.List;

public class ManagerMenu {

    private final DbCompanyDAO companyDAO;

    public ManagerMenu(DbCompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
    
    public void show() {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("1. Company list");
            System.out.println("2. Create a company");
            System.out.println("0. Back");

            int choice = Keyboard.getInt();
            switch (choice) {
                case 1 -> printCompanyList();
                case 2 -> createCompany();
                case 0 -> keepGoing = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
       }
    }

    private List<Company> printCompanyList() {
        List <Company> companies = companyDAO.findAll();
        if (companies.isEmpty()) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println();
            companies.forEach(company -> System.out.println(company.id() + ". " + company.name()));
            System.out.println();
        }
        return companies;
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
