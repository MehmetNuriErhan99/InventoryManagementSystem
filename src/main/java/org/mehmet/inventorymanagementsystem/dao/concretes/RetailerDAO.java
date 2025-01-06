package org.mehmet.inventorymanagementsystem.dao.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IRetailerDAO;
import org.mehmet.inventorymanagementsystem.model.Retailer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetailerDAO implements IRetailerDAO {
    private final Connection connection;

    public RetailerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void registerRetailer(Retailer retailer) throws Exception {
        String query = "INSERT INTO Retailer (name, phoneNumber, emailAddress, password, photo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, retailer.getName());
            preparedStatement.setString(2, retailer.getPhoneNumber());
            preparedStatement.setString(3, retailer.getEmailAddress());
            preparedStatement.setString(4, retailer.getPassword());
            preparedStatement.setString(5, retailer.getPhoto());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Retailer loginRetailer(String email, String password) throws Exception {
        String query = "SELECT * FROM Retailer WHERE emailAddress = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Retailer(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("phoneNumber"),
                            resultSet.getString("emailAddress"),
                            resultSet.getString("password"),
                            resultSet.getString("photo")
                    );
                }
            }
        }
        return null;
    }
}
