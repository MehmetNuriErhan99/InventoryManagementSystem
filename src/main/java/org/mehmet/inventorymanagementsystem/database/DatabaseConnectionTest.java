package org.mehmet.inventorymanagementsystem.database;



import java.sql.Connection;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            System.out.println("Bağlantı başarılı!");
            DatabaseConnection.closeConnection(connection);
        } else {
            System.err.println("Bağlantı başarısız!");
        }
    }
}