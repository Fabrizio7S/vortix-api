package com.vortix.vortix_api.core.business.web.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateBusinessRequest(
        @NotBlank(message = "Business name is required")
        String name
) {
}
