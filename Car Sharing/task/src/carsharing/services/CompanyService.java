package carsharing.services;

import carsharing.DAOImplementations.DbCompanyDAO;
import carsharing.domain.Company;
import carsharing.util.Keyboard;

import java.util.List;

public class CompanyService {
    private final DbCompanyDAO companyDAO;

    public CompanyService(DbCompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public List<Company> getAllCompanies() {
        return companyDAO.findAll();
    }

    public Company getCompanyById(int id) {
        return companyDAO.findById(id);
    }

    public List<Company> displayCompanies() {
        List<Company> companies = getAllCompanies();
        if (companies.isEmpty()) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println("Choose a company:");
            companies.forEach(comp -> System.out.println(comp.id() + ". " + comp.name()));
            System.out.println("0. Back");
        }
        return companies;
    }

    public void createCompany() {
        System.out.println("Enter the company name:");
        String name = Keyboard.getNextLine();
        Company company = new Company(0, name);
        companyDAO.add(company);
        System.out.println("The company was created!");
    }
}