package com.nurbol.car_marketplace.BeysenbayNurbolController;


import com.nurbol.car_marketplace.BeysenbayNurbolDTO.UserCreateDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolDTO.UserResponseDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolEntity.User;
import com.nurbol.car_marketplace.BeysenbayNurbolMapper.UserMapper;
import com.nurbol.car_marketplace.BeysenbayNurbolService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserCreateDTO dto) {
        var user = UserMapper.toEntity(dto);
        var saved = userService.createUser(user);
        return UserMapper.toDTO(saved);
    }
}