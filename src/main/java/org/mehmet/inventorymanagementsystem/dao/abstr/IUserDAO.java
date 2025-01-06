package org.mehmet.inventorymanagementsystem.dao.abstr;

import org.mehmet.inventorymanagementsystem.model.User;
import java.util.List;

public interface IUserDAO {
    void createUser(User user) throws Exception;
    User getUserByEmail(String email) throws Exception;
    List<User> getAllUsers() throws Exception;
    void deleteUser(int id) throws Exception;

    void updateUser(User user);

    User getUserById(int id);
}
