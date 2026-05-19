package com.nurbol.car_marketplace.BeysenbayNurbolMapper;


import com.nurbol.car_marketplace.BeysenbayNurbolDTO.UserCreateDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolDTO.UserResponseDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolEntity.User;
import java.util.List;

public class UserMapper {

    public static User toEntity(UserCreateDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static List<UserResponseDTO> toDTOList(List<User> users) {
        return users.stream()
                .map(UserMapper::toDTO)
                .toList();
    }
}