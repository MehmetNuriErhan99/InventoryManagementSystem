package org.mehmet.inventorymanagementsystem.dao.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IRetailerDAO;
import org.mehmet.inventorymanagementsystem.model.Retailer;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetailerDAO implements IRetailerDAO {

    private final Connection connection;

    public RetailerDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean createRetailer(Retailer retailer) {
        String sql = "INSERT INTO Retailers (name, phoneNumber, emailAddress, password, photo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, retailer.getName());
            stmt.setString(2, retailer.getPhoneNumber());
            stmt.setString(3, retailer.getEmailAddress());
            stmt.setString(4, retailer.getPassword());
            stmt.setString(5, retailer.getPhoto());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public List<Retailer> getAllRetailers() {
        List<Retailer> retailers = new ArrayList<>();
        String sql = "SELECT * FROM Retailers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Retailer retailer = mapToRetailer(rs);
                retailers.add(retailer);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return retailers;
    }

    @Override
    public Retailer getRetailerById(int id) {
        String sql = "SELECT * FROM Retailers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToRetailer(rs);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return null;
    }

    @Override
    public boolean updateRetailer(Retailer retailer) {
        String sql = "UPDATE Retailers SET name = ?, phoneNumber = ?, emailAddress = ?, password = ?, photo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, retailer.getName());
            stmt.setString(2, retailer.getPhoneNumber());
            stmt.setString(3, retailer.getEmailAddress());
            stmt.setString(4, retailer.getPassword());
            stmt.setString(5, retailer.getPhoto());
            stmt.setInt(6, retailer.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public boolean deleteRetailer(int id) {
        String sql = "DELETE FROM Retailers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    private Retailer mapToRetailer(ResultSet rs) throws SQLException {
        return new Retailer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("phoneNumber"),
                rs.getString("emailAddress"),
                rs.getString("password"),
                rs.getString("photo")
        );
    }

    private void handleSQLException(SQLException e) {
        System.err.println("Veritabanı işlemi sırasında hata oluştu: " + e.getMessage());
    }
}
