package com.vortix.vortix_api.security.auth.web;

import com.vortix.vortix_api.core.business.entity.Business;
import com.vortix.vortix_api.core.business.repository.BusinessRepository;
import com.vortix.vortix_api.core.user.entity.User;
import com.vortix.vortix_api.core.user.repository.UserRepository;
import com.vortix.vortix_api.security.config.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessAuthenticationProvider implements AuthenticationProvider {

    private static final String INVALID_CREDENTIALS = "Invalid credentials";

    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        BusinessAuthenticationToken token = (BusinessAuthenticationToken) authentication;

        String businessCode = token.getBusinessCode();
        String email = (String) token.getPrincipal();
        String password = (String) token.getCredentials();

        Business business = businessRepository.findByCode(businessCode)
                .orElseThrow(() -> new BadCredentialsException(INVALID_CREDENTIALS));

        User user = userRepository.findByBusiness_IdAndEmail(business.getId(), email)
                .orElseThrow(() -> new BadCredentialsException(INVALID_CREDENTIALS));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException(INVALID_CREDENTIALS);
        }

        UserPrincipal userPrincipal = new UserPrincipal(user);

        if (!userPrincipal.isEnabled()) {
            throw new DisabledException("User account is disabled");
        }

        return BusinessAuthenticationToken.authenticated(business.getCode(), userPrincipal);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return BusinessAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
