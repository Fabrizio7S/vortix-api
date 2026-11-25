package com.vortix.vortix_api.core.business.exception;

import com.vortix.vortix_api.shared.exception.ResourceNotFoundException;

public class BusinessNotFoundException extends ResourceNotFoundException {
    public BusinessNotFoundException(Long id) {
        super("Business not found with id " + id);
    }
}
