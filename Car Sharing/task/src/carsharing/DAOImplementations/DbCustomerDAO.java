package carsharing.DAOImplementations;

import carsharing.DAOs.CustomerDAO;
import carsharing.domain.Customer;
import carsharing.util.DBClient;

import java.util.List;

public class DbCustomerDAO implements CustomerDAO {
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS CUSTOMER (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL, " +
            "RENTED_CAR_ID INT, " +
            "FOREIGN KEY (RENTED_CAR_ID) REFERENCES CAR(ID)" +
            ");";

    public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER (NAME, RENTED_CAR_ID) VALUES ('%s', %d);";

    public static final String FIND_CUSTOMER_BY_ID = "SELECT * FROM CUSTOMER WHERE ID = %d;";

    private final DBClient dbClient;

    public DbCustomerDAO() {
        dbClient = new DBClient();
        dbClient.run(CREATE_TABLE);
    }

    public List findAll() {
        return dbClient.selectForCustomerList("SELECT * FROM CUSTOMER;");
    }


    public void add(Customer customer) {
        dbClient.run(String.format(INSERT_CUSTOMER, customer.name(), customer.rentedCarId()));
    }

    public Customer findById(int id) {
        return dbClient.selectForCustomer(String.format(FIND_CUSTOMER_BY_ID, id));
    }
}
