package carsharing;

import carsharing.util.Keyboard;

import java.util.List;

public class CompanyService {
    private final DbCompanyDAO companyDAO;

    public CompanyService(DbCompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }


    public Company chooseCompany() {
        System.out.println("Choose a company:");
        List<Company> companies = companyDAO.findAll();
        Company company = null;
        if (companies.isEmpty()) {
            System.out.println("The company list is empty!");
        } else {
            companies.forEach(comp -> System.out.println(comp.id() + ". " + comp.name()));
            int choice = Keyboard.getInt();
            company = getCompanyById(choice);
        }
        return company;
    }

    public Company getCompanyById(int id) {
        Company company = companyDAO.findById(id);
        if (company != null) {
            System.out.println("You selected \"" + company.name() + "\"");
        } else {
            System.out.println("There is no company with this ID!");
        }
        return company;
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
