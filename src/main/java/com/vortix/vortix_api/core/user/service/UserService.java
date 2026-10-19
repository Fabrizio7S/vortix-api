package com.vortix.vortix_api.core.user.service;


import com.vortix.vortix_api.core.user.entity.User;
import com.vortix.vortix_api.core.user.web.request.ChangePasswordRequest;
import com.vortix.vortix_api.core.user.web.request.CreateUserRequest;
import com.vortix.vortix_api.core.user.web.request.UpdateUserRequest;
import com.vortix.vortix_api.core.user.web.response.UserResponse;

public interface UserService {

    User findEntityById(Long id);

    UserResponse create(Long businessId, CreateUserRequest request);

    UserResponse update(Long id, UpdateUserRequest request);

    void changePassword(Long id, ChangePasswordRequest request);
}
