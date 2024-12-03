package carsharing.DAOImplementations;

import carsharing.util.DBClient;

public class DbCustomerDAO {
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS CUSTOMER (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL, " +
            "RENTED_CAR_ID INT, " +
            "FOREIGN KEY (RENTED_CAR_ID) REFERENCES CAR(ID)" +
            ");";

    private final DBClient dbClient;

    public DbCustomerDAO() {
        dbClient = new DBClient();
        dbClient.run(CREATE_TABLE);
    }
}
