package org.mehmet.inventorymanagementsystem.database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = System.getenv("jdbc:mysql://localhost:3307/inventorymanagementsystem"); // Çevresel değişkenlerden URL'yi alıyoruz
    private static final String USER = System.getenv("root"); // Çevresel değişkenlerden kullanıcı adını alıyoruz
    private static final String PASSWORD = System.getenv("rootpassword"); // Çevresel değişkenlerden şifreyi alıyoruz

    // Bu metod ile bağlantıyı kuruyoruz
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanına başarıyla bağlanıldı!");
        } catch (SQLException e) {
            System.err.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
            // Burada daha spesifik hata yönetimi yapılabilir.
        }
        return connection;
    }

    // Try-with-resources kullanarak, bağlantıyı güvenli bir şekilde kapatıyoruz
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
