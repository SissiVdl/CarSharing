package carsharing;

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
}
