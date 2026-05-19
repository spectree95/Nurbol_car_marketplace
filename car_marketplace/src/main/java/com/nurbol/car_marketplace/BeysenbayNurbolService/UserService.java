package com.nurbol.car_marketplace.BeysenbayNurbolService;

import com.nurbol.car_marketplace.BeysenbayNurbolDTO.auth.LoginRequestDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolEntity.User;
import com.nurbol.car_marketplace.BeysenbayNurbolRepository.UserRepository;
import com.nurbol.car_marketplace.BeysenbayNurbolSecurity.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    public String login(LoginRequestDTO dto) {

        var user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        boolean matches = passwordEncoder.matches(
                dto.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new RuntimeException("Invalid password");
        }

        return jwtService.generateToken(user.getEmail());
    }

}
