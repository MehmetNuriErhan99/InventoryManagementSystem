package org.mehmet.inventorymanagementsystem.dao.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IOrderDAO;
import org.mehmet.inventorymanagementsystem.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {
    private final Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createOrder(Order order) {
        String sql = "INSERT INTO orders (supplierId, retailerId, productId, amount, orderStatus, createdAt) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getSupplierId());
            statement.setInt(2, order.getRetailerId());
            statement.setInt(3, order.getProductId());
            statement.setInt(4, order.getAmount());
            statement.setString(5, order.getOrderStatus());
            statement.setTimestamp(6, Timestamp.valueOf(order.getCreatedAt()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapToOrder(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getOrdersBySupplierId(int supplierId) {
        String sql = "SELECT * FROM orders WHERE supplierId = ?";
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, supplierId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(mapToOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getOrdersByRetailerId(int retailerId) {
        String sql = "SELECT * FROM orders WHERE retailerId = ?";
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, retailerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(mapToOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void updateOrderStatus(int id, String status) {
        String sql = "UPDATE orders SET orderStatus = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, status);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Order mapToOrder(ResultSet resultSet) throws SQLException {
        return new Order(
                resultSet.getInt("id"),
                resultSet.getInt("supplierId"),
                resultSet.getInt("retailerId"),
                resultSet.getInt("productId"),
                resultSet.getInt("amount"),
                resultSet.getString("orderStatus"),
                resultSet.getTimestamp("createdAt").toLocalDateTime()
        );
    }

}
