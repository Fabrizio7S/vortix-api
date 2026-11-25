package com.vortix.vortix_api.core.user.exception;

import com.vortix.vortix_api.shared.exception.ResourceNotFoundException;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(Long id) {
        super("User not found with id " +id);
    }
}
