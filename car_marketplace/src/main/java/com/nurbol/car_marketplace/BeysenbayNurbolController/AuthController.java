package com.nurbol.car_marketplace.BeysenbayNurbolController;

import com.nurbol.car_marketplace.BeysenbayNurbolDTO.auth.AuthResponseDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolDTO.auth.LoginRequestDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public AuthResponseDTO login(
            @RequestBody LoginRequestDTO dto
    ) {

        String token = userService.login(dto);

        return new AuthResponseDTO(token);
    }
}