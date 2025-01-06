package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.converter.UserConverter;
import org.mehmet.inventorymanagementsystem.dao.abstr.IUserDAO;
import org.mehmet.inventorymanagementsystem.dto.user.UserRegisterDTO;
import org.mehmet.inventorymanagementsystem.dto.user.UserResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.user.UserLoginDTO;
import org.mehmet.inventorymanagementsystem.model.User;
import org.mehmet.inventorymanagementsystem.service.abstr.IUserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserService implements IUserService {

    private final IUserDAO userDAO;
    private final UserConverter userConverter;

    public UserService(IUserDAO userDAO, UserConverter userConverter) {
        this.userDAO = userDAO;
        this.userConverter = userConverter;
    }

    @Override
    public void registerUser(UserRegisterDTO dto) throws Exception {
        User user = userConverter.toEntity(dto);
        userDAO.createUser(user);
    }

    @Override
    public UserResponseDTO loginUser(UserLoginDTO dto) throws Exception {
        User user = userDAO.getUserByEmail(dto.getEmail());
        if (user != null && user.getPassword().equals(dto.getPassword())) {
            return userConverter.toResponseDTO(user);
        } else {
            throw new Exception("Invalid email or password.");
        }
    }

    @Override
    public List<UserResponseDTO> getAllUsers() throws Exception {
        List<User> users = userDAO.getAllUsers();
        return users.stream()
                .map(userConverter::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(int id) throws Exception {
        User user = userDAO.getUserById(id);
        if (user == null) {
            throw new Exception("User not found with ID: " + id);
        }
        return userConverter.toResponseDTO(user);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        userDAO.deleteUser(id);
    }
}
