package com.vortix.vortix_api.core.user.model.web.response;

import com.vortix.vortix_api.core.user.model.enums.UserRole;
import com.vortix.vortix_api.core.user.model.enums.UserStatus;

public record UserResponse(
        Long id,
        String email,
        UserStatus  staus,
        UserRole role
) {
}
