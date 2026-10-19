package com.vortix.vortix_api.core.user.service;

import com.vortix.vortix_api.core.business.entity.Business;
import com.vortix.vortix_api.core.business.service.BusinessService;
import com.vortix.vortix_api.core.user.component.UserMapper;
import com.vortix.vortix_api.core.user.entity.User;
import com.vortix.vortix_api.core.user.enums.UserStatus;
import com.vortix.vortix_api.core.user.exception.InvalidPasswordException;
import com.vortix.vortix_api.core.user.exception.UserNotFoundException;
import com.vortix.vortix_api.core.user.repository.UserRepository;
import com.vortix.vortix_api.core.user.web.request.ChangePasswordRequest;
import com.vortix.vortix_api.core.user.web.request.CreateUserRequest;
import com.vortix.vortix_api.core.user.web.request.UpdateUserRequest;
import com.vortix.vortix_api.core.user.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final BusinessService businessService;

    @Override
    @Transactional(readOnly = true)
    public User findEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    @Transactional
    public UserResponse create(Long businessId, CreateUserRequest request) {

        Business business = businessService.findEntityById(businessId);
        String encodedPassword = passwordEncoder.encode(request.password());
        User user = User.builder()
                .email(request.email())
                .password(encodedPassword)
                .role(request.role())
                .status(UserStatus.ACTIVE)
                .business(business)
                .build();
        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    @Override
    @Transactional
    public UserResponse update(Long id, UpdateUserRequest request) {

        User user = findEntityById(id);
        user.update(request.email(), request.role());

        return userMapper.toResponse(user);
    }

    @Override
    @Transactional
    public void changePassword(Long id, ChangePasswordRequest request) {
        User user = findEntityById(id);

        if (!passwordEncoder.matches(
                request.currentPassword(),
                user.getPassword())) {

            throw new InvalidPasswordException();
        }

        String encodedPassword =
                passwordEncoder.encode(request.newPassword());

        user.updatePassword(encodedPassword);
    }

}