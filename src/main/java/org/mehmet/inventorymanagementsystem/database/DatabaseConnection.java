package org.mehmet.inventorymanagementsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3307/inventorymanagementsystem"; // URL'yi güncelle
    private static final String USER = "root"; // Kullanıcı adı
    private static final String PASSWORD = "rootpassword"; // Şifre

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanına başarıyla bağlanıldı!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
            return null; // Hata durumunda null döndürüyoruz
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Veritabanı bağlantısı kapatıldı.");
            } catch (SQLException e) {
                System.err.println("Bağlantı kapatılırken hata oluştu: " + e.getMessage());
            }
        }
    }
}
