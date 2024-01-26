package com.fconsigny.springboot.datasource.api.archetype.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
public class ApiKeyAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter{
    @Value("${app.spring.security.secure.auth.method}")
    private String principalRequestHeader;

    public ApiKeyAuthenticationFilter(String principalRequestHeader) {
        this.principalRequestHeader = principalRequestHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(principalRequestHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }
}
