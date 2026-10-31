package com.vortix.vortix_api.security.auth.web.controller;

import com.vortix.vortix_api.security.auth.service.AuthService;
import com.vortix.vortix_api.security.auth.web.request.RegisterRequest;
import com.vortix.vortix_api.security.auth.web.response.RegisterResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}
