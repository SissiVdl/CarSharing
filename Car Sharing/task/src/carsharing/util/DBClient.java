package carsharing.util;

import carsharing.domain.Car;
import carsharing.domain.Company;
import carsharing.domain.Customer;
import org.h2.jdbcx.JdbcDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBClient {

    private final DataSource dataSource;
    private static final String CONNECTION_URL = "jdbc:h2:file:./src/carsharing/db/carsharing";

    // DB client has a data source
    public DBClient() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(CONNECTION_URL);
        this.dataSource = dataSource;
    }

    // makes connection and executes SQL statements
    public void run(String str) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()
        ) {
            connection.setAutoCommit(true);
            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // makes connection, executes SQL, processes resultset to returns a list of companies
    public List<Company> selectForCompanyList(String query) {
        List<Company> companies = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            connection.setAutoCommit(true);
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                companies.add(new Company(ID, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    public Company selectForCompany(String query) {
        Company company = null;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            connection.setAutoCommit(true);
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                company = new Company(ID, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public List<Car> selectForCarList(String query) {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            connection.setAutoCommit(true);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int companyId = resultSet.getInt("COMPANY_ID");
                cars.add(new Car(id, name, companyId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public List selectForCustomerList(String query) {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            connection.setAutoCommit(true);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int rentedCarId = resultSet.getInt("RENTED_CAR_ID");
                customers.add(new Customer(id, name, rentedCarId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer selectForCustomer(String format) {
        Customer customer = null;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(format)) {
            connection.setAutoCommit(true);
            if (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int rentedCarId = resultSet.getInt("RENTED_CAR_ID");
                customer = new Customer(id, name, rentedCarId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
