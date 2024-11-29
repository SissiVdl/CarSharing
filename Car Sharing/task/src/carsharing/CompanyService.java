package carsharing;

import carsharing.util.Keyboard;

import java.util.List;

public class CompanyService {
    private final DbCompanyDAO companyDAO;

    public CompanyService(DbCompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public void printCompanyList() {
        List<Company> companies = companyDAO.findAll();
        if (companies.isEmpty()) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println();
            companies.forEach(company -> System.out.println(company.id() + ". " + company.name()));
            System.out.println();
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
