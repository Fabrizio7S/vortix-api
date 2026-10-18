package com.vortix.vortix_api.core.user.model.web.request;

import com.vortix.vortix_api.core.user.model.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "Email is required ")
        @Email(message = "Invalid email format")
        String email,
        @NotBlank(message = "Password is required")
        @Size(min = 8,message = "Password must contain at least 8 characters")
        String password,
        @NotNull(message = "Role is required")
        UserRole role
) {
}
