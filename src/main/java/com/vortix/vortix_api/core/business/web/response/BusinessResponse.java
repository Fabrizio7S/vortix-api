package com.vortix.vortix_api.core.business.web.response;

import java.time.LocalDate;

public record BusinessResponse(
        Long id,
        String name,
        LocalDate startDate
) {
}
