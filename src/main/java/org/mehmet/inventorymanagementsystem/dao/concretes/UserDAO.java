package org.mehmet.inventorymanagementsystem.dao.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IUserDAO;
import org.mehmet.inventorymanagementsystem.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createUser(User user) throws Exception {
        String query = "INSERT INTO User (name, phoneNumber, email, password, role, photo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhoneNumber());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getPhoto());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error inserting user into the database", e);
        }
    }


    @Override
    public User getUserByEmail(String email) throws Exception {
        String query = "SELECT * FROM User WHERE email = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("role"),
                            rs.getString("phoneNumber"),
                            rs.getString("photo")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        String query = "SELECT * FROM User";
        List<User> users = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("phoneNumber"),
                        rs.getString("photo")
                ));
            }
        }
        return users;
    }

    @Override
    public void deleteUser(int id) throws Exception {
        String query = "DELETE FROM User WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    public List<User> getAllSuppliers() {
        return null;
    }
}
