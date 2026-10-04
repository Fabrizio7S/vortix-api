package com.vortix.vortix_api.core.business.exception;

public class BusinessNotFoundException extends RuntimeException {
    public BusinessNotFoundException(Long id) {
        super("Business not found with id" + id);
    }
}
