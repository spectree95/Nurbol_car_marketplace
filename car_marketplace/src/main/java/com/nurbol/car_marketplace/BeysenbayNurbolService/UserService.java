package com.nurbol.car_marketplace.BeysenbayNurbolService;

import com.nurbol.car_marketplace.BeysenbayNurbolEntity.User;
import com.nurbol.car_marketplace.BeysenbayNurbolRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}