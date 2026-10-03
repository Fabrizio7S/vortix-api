package com.vortix.vortix_api.shared.exception;

public record FieldErrorResponse(
        String field,
        String message
) {
}
