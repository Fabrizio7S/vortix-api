package com.vortix.vortix_api.security.auth.web;

import com.vortix.vortix_api.security.config.UserPrincipal;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class BusinessAuthenticationToken extends AbstractAuthenticationToken {

    private final String businessCode;
    private final Object principal;
    private Object credentials;

    private BusinessAuthenticationToken(String businessCode, String email, String password) {
        super(List.of());
        this.businessCode = businessCode;
        this.principal = email;
        this.credentials = password;
        super.setAuthenticated(false);
    }

    private BusinessAuthenticationToken(String businessCode, UserPrincipal userPrincipal) {
        super(userPrincipal.getAuthorities());
        this.businessCode = businessCode;
        this.principal = userPrincipal;
        this.credentials = null;
        super.setAuthenticated(true);
    }

    public static BusinessAuthenticationToken unauthenticated(String businessCode, String email, String password) {
        return new BusinessAuthenticationToken(businessCode, email, password);
    }

    public static BusinessAuthenticationToken authenticated(String businessCode, UserPrincipal userPrincipal) {
        return new BusinessAuthenticationToken(businessCode, userPrincipal);
    }

    public String getBusinessCode() {
        return businessCode;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        if (authenticated) {
            throw new IllegalArgumentException(
                    "Usa BusinessAuthenticationToken.authenticated(...) para crear un token autenticado");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }
}
