package org.mehmet.inventorymanagementsystem.dao.concretes;

import org.mehmet.inventorymanagementsystem.model.User;
import org.mehmet.inventorymanagementsystem.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {

    private final Connection connection;

    public SupplierDAO(Connection connection) {
        this.connection = connection;
    }


    public List<User> getAllSuppliers() throws SQLException {
        String query = "SELECT * FROM User WHERE role = 'Supplier'";
        List<User> suppliers = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("photo")
                );
                suppliers.add(user);
            }
        }
        return suppliers;
    }

    public void addSupplier(User supplier) throws SQLException {
        String query = "INSERT INTO User (name, email, password, role, phoneNumber, photo) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getEmail());
            preparedStatement.setString(3, supplier.getPassword());
            preparedStatement.setString(4, "Supplier");
            preparedStatement.setString(5, supplier.getPhoneNumber());
            preparedStatement.setString(6, supplier.getPhoto());
            preparedStatement.executeUpdate();
        }
    }


    public void updateSupplier(User supplier) throws SQLException {
        String query = "UPDATE User SET name = ?, email = ?, password = ?, phoneNumber = ?, photo = ? WHERE id = ? AND role = 'Supplier'";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getEmail());
            preparedStatement.setString(3, supplier.getPassword());
            preparedStatement.setString(4, supplier.getPhoneNumber());
            preparedStatement.setString(5, supplier.getPhoto());
            preparedStatement.setInt(6, supplier.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteSupplier(int supplierId) throws SQLException {
        String query = "DELETE FROM User WHERE id = ? AND role = 'Supplier'";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, supplierId);
            preparedStatement.executeUpdate();
        }
    }


    public List<Order> getSupplierOrders(int supplierId) throws SQLException {
        String query = "SELECT * FROM Orders WHERE supplierId = ?";
        List<Order> orders = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, supplierId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getInt("supplierId"),
                        resultSet.getInt("retailerId"),
                        resultSet.getInt("productId"),
                        resultSet.getInt("amount"),
                        resultSet.getString("orderStatus"),
                        resultSet.getTimestamp("createdAt").toLocalDateTime()
                );
                orders.add(order);
            }
        }
        return orders;
    }

    public void updateOrderStatus(int orderId, String newStatus) throws SQLException {
        String query = "UPDATE Orders SET orderStatus = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        }
    }
}
