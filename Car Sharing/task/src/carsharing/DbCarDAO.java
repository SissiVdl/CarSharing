package carsharing;

import carsharing.util.DBClient;

public class DbCarDAO implements CarDAO {

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS CAR (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL, " +
            "COMPANY_ID INT NOT NULL, " +
            "FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY(ID)" +
            ");";

    private final DBClient dbClient;

    public DbCarDAO() {
        dbClient = new DBClient();
        dbClient.run(CREATE_TABLE);
    }
}
