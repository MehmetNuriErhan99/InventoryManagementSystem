package org.mehmet.inventorymanagementsystem.dao.concretes;


import org.mehmet.inventorymanagementsystem.dao.abstr.IProductDAO;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import org.mehmet.inventorymanagementsystem.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private final Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createProduct(Product product) throws SQLException {
        String query = "INSERT INTO Product (name, stockQuantity, price, discount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStockQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.setDouble(4, product.getDiscount());
            stmt.executeUpdate();
        }
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        String query = "SELECT * FROM Product WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("stockQuantity"),
                            rs.getDouble("price"),
                            rs.getDouble("discount")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("stockQuantity"),
                        rs.getDouble("price"),
                        rs.getDouble("discount")
                ));
            }
        }
        return products;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String query = "UPDATE Product SET name = ?, stockQuantity = ?, price = ?, discount = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStockQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.setDouble(4, product.getDiscount());
            stmt.setInt(5, product.getId());
            stmt.executeUpdate();
        }
    }


    @Override
    public void deleteProduct(int id) throws SQLException {
        String query = "DELETE FROM Product WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Product> getProductsByName(String name) throws Exception {
        String query = "SELECT * FROM Product WHERE name LIKE ?";
        List<Product> products = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + name + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    products.add(new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("stockQuantity"),
                            rs.getDouble("price"),
                            rs.getDouble("discount")
                    ));
                }
            }
        }
        return products;
    }

    @Override
    public List<Product> searchProductsByName(String name) throws Exception {
        ProductDAO productDAO = new ProductDAO(DatabaseConnection.getConnection());
        ProductDAO productDAO1 = productDAO;
        return productDAO.searchProductsByName(name);
    }
}
