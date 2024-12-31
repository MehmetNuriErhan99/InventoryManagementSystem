package org.mehmet.inventorymanagementsystem.dao.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IProductDAO;
import org.mehmet.inventorymanagementsystem.model.Product;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private final Connection connection;

    public ProductDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean createProduct(Product product) {
        String sql = "INSERT INTO products (name, stock_quantity, price, discount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStockQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.setDouble(4, product.getDiscount());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Product product = mapToProduct(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToProduct(rs);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET name = ?, stock_quantity = ?, price = ?, discount = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStockQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.setDouble(4, product.getDiscount());
            stmt.setInt(5, product.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    // Helper method to map ResultSet to Product
    private Product mapToProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("stock_quantity"),
                rs.getDouble("price"),
                rs.getDouble("discount")
        );
    }

    // Handle SQLException
    private void handleSQLException(SQLException e) {
        System.err.println("Veritabanı işlemi sırasında hata oluştu: " + e.getMessage());
    }
}

