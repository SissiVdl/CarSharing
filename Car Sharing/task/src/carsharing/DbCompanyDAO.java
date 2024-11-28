package carsharing;
import carsharing.util.DBClient;
import java.net.URL;
import java.util.List;

public class DbCompanyDAO implements CompanyDAO {
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS COMPANY (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL" +
            ");";

    private static final String INSERT_COMPANY = "INSERT INTO COMPANY VALUES (%d, '%s');";
    private static final String LIST_ALL_COMPANIES = "SELECT * FROM COMPANY;";

    private static final DBClient dbClient = new DBClient();

    public DbCompanyDAO() {
        dbClient.run(CREATE_TABLE);
        System.out.println("Table created");
    }

    public void add(Company company) {
        dbClient.run(String.format(INSERT_COMPANY, company.id(), company.name()));
    }

    public List<Company> findAll() {
        List<Company> companies = dbClient.selectForCompanyList(LIST_ALL_COMPANIES);
        companies.forEach(company -> System.out.println(company.id() + ". " + company.name()));
        return companies;
    }
}
