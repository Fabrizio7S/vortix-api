package com.vortix.vortix_api.security.auth.web.response;

import com.vortix.vortix_api.core.business.web.response.BusinessResponse;
import com.vortix.vortix_api.core.user.web.response.UserResponse;

public record RegisterResponse(
        BusinessResponse business,
        UserResponse admin
) {
}
