package org.mehmet.inventorymanagementsystem.dao.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.ICartDAO;
import org.mehmet.inventorymanagementsystem.model.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO {

    private final Connection connection;

    // CartDAO constructor'ı: Dışarıdan Connection parametresi alacak şekilde yazıldı.
    public CartDAO(Connection connection) {
        this.connection = connection; // Verilen connection parametresini sınıf değişkenine atıyoruz.
    }

    @Override
    public void addProductToCart(Cart cart) throws SQLException {
        String query = "INSERT INTO Cart (retailerId, productId, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, cart.getRetailerId());
            preparedStatement.setInt(2, cart.getProductId());
            preparedStatement.setInt(3, cart.getQuantity());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateCart(Cart cart) throws SQLException {
        String query = "UPDATE Cart SET quantity = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, cart.getQuantity());
            preparedStatement.setInt(2, cart.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void removeProductFromCart(int id) throws SQLException {
        String query = "DELETE FROM Cart WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Cart> getCartByRetailerId(int retailerId) throws SQLException {
        List<Cart> cartItems = new ArrayList<>();
        String query = "SELECT * FROM Cart WHERE retailerId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, retailerId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    cartItems.add(new Cart(
                            resultSet.getInt("id"),
                            resultSet.getInt("retailerId"),
                            resultSet.getInt("productId"),
                            resultSet.getInt("quantity")
                    ));
                }
            }
        }
        return cartItems;
    }

    @Override
    public void clearCartByRetailerId(int retailerId) throws SQLException {
        String query = "DELETE FROM Cart WHERE retailerId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, retailerId);
            preparedStatement.executeUpdate();
        }
    }
}
