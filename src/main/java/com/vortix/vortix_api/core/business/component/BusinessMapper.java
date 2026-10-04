package com.vortix.vortix_api.core.business.component;

import com.vortix.vortix_api.core.business.entity.Business;
import com.vortix.vortix_api.core.business.web.response.BusinessResponse;
import org.springframework.stereotype.Component;

@Component
public class BusinessMapper {

    public BusinessResponse toResponse(Business business) {
        return new BusinessResponse(
                business.getId(),
                business.getName(),
                business.getStartDate()
        );
    }
}
