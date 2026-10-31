package com.vortix.vortix_api.security.auth.service;

import com.vortix.vortix_api.core.business.service.BusinessService;
import com.vortix.vortix_api.core.business.web.request.CreateBusinessRequest;
import com.vortix.vortix_api.core.business.web.response.BusinessResponse;
import com.vortix.vortix_api.core.user.enums.UserRole;
import com.vortix.vortix_api.core.user.service.UserService;
import com.vortix.vortix_api.core.user.web.request.CreateUserRequest;
import com.vortix.vortix_api.core.user.web.response.UserResponse;
import com.vortix.vortix_api.security.auth.web.request.RegisterRequest;
import com.vortix.vortix_api.security.auth.web.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final BusinessService businessService;
    private final UserService userService;

    @Override
    @Transactional
    public RegisterResponse register(RegisterRequest request) {
        BusinessResponse business = businessService.create(
                new CreateBusinessRequest(request.businessName())
        );

        UserResponse admin = userService.create(
                business.id(),
                new CreateUserRequest(request.email(), request.password(), UserRole.ADMIN)
        );

        return new RegisterResponse(business, admin);
    }
}
