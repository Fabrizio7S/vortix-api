package com.vortix.vortix_api.core.business.service;

import com.vortix.vortix_api.core.business.entity.Business;
import com.vortix.vortix_api.core.business.web.request.CreateBusinessRequest;
import com.vortix.vortix_api.core.business.web.request.UpdateBusinessRequest;
import com.vortix.vortix_api.core.business.web.response.BusinessResponse;

public interface BusinessService {

    Business findEntityById(long id);

    BusinessResponse create (CreateBusinessRequest request);

    BusinessResponse update (Long id,UpdateBusinessRequest request);

}
