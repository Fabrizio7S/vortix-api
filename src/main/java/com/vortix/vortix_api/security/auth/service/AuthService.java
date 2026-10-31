package com.vortix.vortix_api.security.auth.service;

import com.vortix.vortix_api.security.auth.web.request.RegisterRequest;
import com.vortix.vortix_api.security.auth.web.response.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);
}
