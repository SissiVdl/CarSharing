package carsharing.services;

import carsharing.DAOImplementations.DbCompanyDAO;
import carsharing.DAOs.CompanyDAO;
import carsharing.domain.Company;
import carsharing.util.Keyboard;

import java.util.List;

public class CompanyService {
    private final CompanyDAO companyDAO;

    public CompanyService(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public List<Company> getAllCompanies() {
        return companyDAO.findAll();
    }

    public Company getCompanyById(int id) {
        return companyDAO.findById(id);
    }


    public void createCompany() {
        System.out.println("Enter the company name:");
        String name = Keyboard.getNextLine();
        Company company = new Company(null, name);
        companyDAO.add(company);
        System.out.println("The company was created!");
    }
}