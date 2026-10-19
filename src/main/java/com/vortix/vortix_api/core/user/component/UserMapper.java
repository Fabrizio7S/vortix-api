package com.vortix.vortix_api.core.user.component;

import com.vortix.vortix_api.core.user.entity.User;
import com.vortix.vortix_api.core.user.web.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getStatus(),
                user.getRole()
        );
    }
}
