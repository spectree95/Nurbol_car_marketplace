package com.nurbol.car_marketplace.BeysenbayNurbolController;


import com.nurbol.car_marketplace.BeysenbayNurbolEntity.User;
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
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}