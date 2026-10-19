package com.vortix.vortix_api.core.user.web.response;

import com.vortix.vortix_api.core.user.enums.UserRole;
import com.vortix.vortix_api.core.user.enums.UserStatus;

public record UserResponse(
        Long id,
        String email,
        UserStatus  status,
        UserRole role
) {
}
