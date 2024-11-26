package carsharing.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    public static void createDatabase(String[] args) {
        String databaseFileName = "default"; // Default value
        for (int i = 0; i < args.length; i++) {
            if ("-databaseFileName".equals(args[i]) && i + 1 < args.length) {
                databaseFileName = args[i + 1];
                break;
            }
        }
        String directoryPath = "jdbc:h2:file:./src/carsharing/db/";
        String url = directoryPath + databaseFileName;

        // Ensure the directory exists
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            // Step 1: Register the JDBC database driver
            Class.forName("org.h2.Driver");

            // Step 2: Open the connection
            Connection conn = DriverManager.getConnection(url);
            conn.setAutoCommit(true);

            // Step 3: Create a statement
            Statement st = conn.createStatement();

            // Step 4: Execute a statement
            String createTableSQL = "CREATE TABLE IF NOT EXISTS COMPANY (" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "NAME VARCHAR(255) NOT NULL)";
            st.executeUpdate(createTableSQL);

            // Step 5: Close the connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}