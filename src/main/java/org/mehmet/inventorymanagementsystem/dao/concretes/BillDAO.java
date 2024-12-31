package org.mehmet.inventorymanagementsystem.dao.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IBillDAO;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import org.mehmet.inventorymanagementsystem.model.Bill;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO implements IBillDAO {

    private final Connection connection;

    public BillDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean createBill(Bill bill) {
        String sql = "INSERT INTO bills (supplier_id, retailer_id, product_id, amount, current_price, date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bill.getSupplierId());
            stmt.setInt(2, bill.getRetailerId());
            stmt.setInt(3, bill.getProductId());
            stmt.setInt(4, bill.getAmount());
            stmt.setDouble(5, bill.getCurrentPrice());
            stmt.setTimestamp(6, new Timestamp(bill.getDate().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        String sql = "SELECT * FROM bills";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Bill bill = mapToBill(rs);
                bills.add(bill);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return bills;
    }

    @Override
    public Bill getBillById(int id) {
        String sql = "SELECT * FROM bills WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToBill(rs);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return null;
    }

    @Override
    public boolean updateBill(Bill bill) {
        String sql = "UPDATE bills SET supplier_id = ?, retailer_id = ?, product_id = ?, amount = ?, current_price = ?, date = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bill.getSupplierId());
            stmt.setInt(2, bill.getRetailerId());
            stmt.setInt(3, bill.getProductId());
            stmt.setInt(4, bill.getAmount());
            stmt.setDouble(5, bill.getCurrentPrice());
            stmt.setTimestamp(6, new Timestamp(bill.getDate().getTime()));
            stmt.setInt(7, bill.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public boolean deleteBill(int id) {
        String sql = "DELETE FROM bills WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    private Bill mapToBill(ResultSet rs) throws SQLException {
        return new Bill(
                rs.getInt("id"),
                rs.getInt("supplier_id"),
                rs.getInt("retailer_id"),
                rs.getInt("product_id"),
                rs.getInt("amount"),
                rs.getDouble("current_price"),
                rs.getTimestamp("date")
        );
    }

    private void handleSQLException(SQLException e) {
        System.err.println("Veritabanı işlemi sırasında hata oluştu: " + e.getMessage());
    }
}
