package carsharing.DAOImplementations;

import carsharing.DAOs.CarDAO;
import carsharing.domain.Car;
import carsharing.util.DBClient;

import java.util.List;

public class DbCarDAO implements CarDAO {

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS CAR (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL, " +
            "COMPANY_ID INT NOT NULL, " +
            "FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY(ID)" +
            ");";

    private static final String INSERT_CAR = "INSERT INTO CAR (NAME, COMPANY_ID) VALUES ('%s', %d);";

    private static final String LIST_ALL_CARS_FOR_COMPANY = "SELECT * FROM CAR WHERE COMPANY_ID = %d;";

    private final DBClient dbClient;

    public DbCarDAO() {
        dbClient = new DBClient();
        dbClient.run(CREATE_TABLE);
    }

    public List<Car> findAllForCompany(int companyId) {
        return dbClient.selectForCarList(String.format(LIST_ALL_CARS_FOR_COMPANY, companyId));
    }
    public void add(Car car) {
        dbClient.run(String.format(INSERT_CAR, car.name(), car.companyId()));
    }
}
