package com.vortix.vortix_api.core.user.web.controller;

import com.vortix.vortix_api.core.user.service.UserService;
import com.vortix.vortix_api.core.user.web.request.ChangePasswordRequest;
import com.vortix.vortix_api.core.user.web.request.CreateUserRequest;
import com.vortix.vortix_api.core.user.web.request.UpdateUserRequest;
import com.vortix.vortix_api.core.user.web.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user_account")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/business/{businessId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create ( @PathVariable Long businessId,@Valid @RequestBody CreateUserRequest request) {
        return  userService.create(businessId,request);
    }

    @PutMapping("/{id}")
    public UserResponse update (@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request) {
        return userService.update(id,request);
    }

    @PatchMapping("/{id}/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePassword(@PathVariable Long id, @Valid @RequestBody ChangePasswordRequest request) {
        userService.changePassword(id, request);
    }
}
