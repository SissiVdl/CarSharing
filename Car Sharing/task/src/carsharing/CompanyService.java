package carsharing;

import carsharing.util.DBClient;

public class CompanyService {

    private static final DBClient dbClient = new DBClient();
    public static void companyList() {

        // Add some companies to the table for testing purposes
        dbClient.run("INSERT INTO COMPANY (NAME) VALUES ('First company name')");
        dbClient.run("INSERT INTO COMPANY (NAME) VALUES ('Second company name')");
        dbClient.run("INSERT INTO COMPANY (NAME) VALUES ('Third company name')");

        // Find and print all companies that are in the table
        CompanyDAO companyDAO = new DbCompanyDAO();
        companyDAO
                .findAll()
                .forEach(company -> System.out.println(company.id() + ". " + company.name()));
    }
}
