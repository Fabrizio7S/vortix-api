package com.vortix.vortix_api.core.user.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChangePasswordRequest(
        @NotBlank(message = "Current password is required")
        String currentPassword,
        @NotBlank(message = "New password is required ")
        @Size(min = 8)
        String newPassword
) {
}
