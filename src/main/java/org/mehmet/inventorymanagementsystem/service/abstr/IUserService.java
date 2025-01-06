package org.mehmet.inventorymanagementsystem.service.abstr;

import org.mehmet.inventorymanagementsystem.dto.user.UserRegisterDTO;
import org.mehmet.inventorymanagementsystem.dto.user.UserResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.user.UserLoginDTO;

import java.util.List;

public interface IUserService {
    void registerUser(UserRegisterDTO dto) throws Exception;
    UserResponseDTO loginUser(UserLoginDTO dto) throws Exception;
    List<UserResponseDTO> getAllUsers() throws Exception;
    UserResponseDTO getUserById(int id) throws Exception;
    void deleteUser(int id) throws Exception;
}
