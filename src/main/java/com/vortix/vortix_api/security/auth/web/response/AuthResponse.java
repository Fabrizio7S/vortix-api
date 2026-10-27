package com.vortix.vortix_api.security.auth.web.response;

public record AuthResponse(
        Long userId,
        String email,
        String role,
        Long businessId,
        String businessCode
) {
}
