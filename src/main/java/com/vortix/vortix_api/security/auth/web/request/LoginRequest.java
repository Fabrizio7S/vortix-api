package com.vortix.vortix_api.security.auth.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(

        @NotBlank(message = "Business code is required")
        @Size(max = 100,message = "Business code must not exceed 100 characters")
        String businessCode,

        @NotBlank(message = "Email is required")
        @Size(max = 150,message = "Email must not exceed 150 chareacters")
        String email,

        @NotBlank(message = "Password is required")
        String password
) {
}
