package com.azurita.azuritaweb.Security.DTO;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDTO {
    private Long customerId;
    private String token;
    private String bearer = "Bearer";
    private String email;

    private Collection<? extends GrantedAuthority> authorities;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public JwtDTO(Long customerId, String token, String email, Collection<? extends GrantedAuthority> authorities) {
        this.customerId = customerId;
        this.token = token;
        this.email = email;
        this.authorities = authorities;

    }
}
