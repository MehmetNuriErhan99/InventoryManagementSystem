package org.mehmet.inventorymanagementsystem.dao.concretes;


import org.mehmet.inventorymanagementsystem.dao.abstr.ISupplierDAO;
import org.mehmet.inventorymanagementsystem.model.Supplier;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements ISupplierDAO {

    private final Connection connection;

    public SupplierDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean createSupplier(Supplier supplier) {
        String sql = "INSERT INTO suppliers (name, phone_number, email_address, password, photo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getPhoneNumber());
            stmt.setString(3, supplier.getEmailAddress());
            stmt.setString(4, supplier.getPassword());
            stmt.setString(5, supplier.getPhoto());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM suppliers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Supplier supplier = mapToSupplier(rs);
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return suppliers;
    }

    @Override
    public Supplier getSupplierById(int id) {
        String sql = "SELECT * FROM suppliers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToSupplier(rs);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return null;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        String sql = "UPDATE suppliers SET name = ?, phone_number = ?, email_address = ?, password = ?, photo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getPhoneNumber());
            stmt.setString(3, supplier.getEmailAddress());
            stmt.setString(4, supplier.getPassword());
            stmt.setString(5, supplier.getPhoto());
            stmt.setInt(6, supplier.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public boolean deleteSupplier(int id) {
        String sql = "DELETE FROM suppliers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    // Helper method to map ResultSet to Supplier
    private Supplier mapToSupplier(ResultSet rs) throws SQLException {
        return new Supplier(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("phone_number"),
                rs.getString("email_address"),
                rs.getString("password"),
                rs.getString("photo")
        );
    }

    // Handle SQLException
    private void handleSQLException(SQLException e) {
        System.err.println("Veritabanı işlemi sırasında hata oluştu: " + e.getMessage());
    }
}
