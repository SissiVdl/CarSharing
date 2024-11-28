package carsharing.util;

import carsharing.Company;
import carsharing.CompanyDAO;
import org.h2.jdbcx.JdbcDataSource;
import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBClient {

    private static DataSource dataSource;
    private static final String CONNECTION_URL = "jdbc:h2:file:./src/carsharing/db/carsharing";

    public DBClient() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(CONNECTION_URL);
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void run(String str) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Company> selectForCompanyList(String query) {
        List<Company> companies = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
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
}
