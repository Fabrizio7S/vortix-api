package com.vortix.vortix_api.core.user.model.component;

import com.vortix.vortix_api.core.user.model.entity.User;
import com.vortix.vortix_api.core.user.model.web.response.UserResponse;
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
