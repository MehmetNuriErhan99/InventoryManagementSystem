package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.user.UserRegisterDTO;
import org.mehmet.inventorymanagementsystem.dto.user.UserResponseDTO;
import org.mehmet.inventorymanagementsystem.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {
    public User toEntity(UserRegisterDTO dto) {
        return new User(
                0, // ID auto-generated
                dto.getName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getRole(),
                dto.getPhoneNumber(),
                dto.getPhoto()
        );
    }

    public UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getPhoneNumber(),
                user.getPhoto()
        );
    }

    public List<UserResponseDTO> toResponseDTOList(List<User> users) {
        return users.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
}
