package org.youjhin.stamowebapp.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN("ROLE_ADMIN"),
    DOCTOR("ROLE_DOCTOR");
    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
