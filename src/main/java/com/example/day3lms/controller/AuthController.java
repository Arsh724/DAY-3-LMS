package com.example.day3lms.controller;

import com.example.day3lms.dto.LoginRequestDto;
import com.example.day3lms.dto.RegisterRequestDto;
import com.example.day3lms.dto.TokenResponseDto;
import com.example.day3lms.repository.UserRepository;
import com.example.day3lms.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    public  AuthController(AuthService Service) {
        this.authService=Service;
    }
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
    return authService.login(loginRequestDto);
    }
    @PostMapping("/register")
    public TokenResponseDto register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        return authService.register(registerRequestDto);
    }
}
