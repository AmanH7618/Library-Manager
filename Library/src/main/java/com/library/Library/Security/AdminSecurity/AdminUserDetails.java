package com.library.Library.Security.AdminSecurity;

import com.library.Library.Admin.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AdminUserDetails implements UserDetails {
    private final Admin admin;

    public AdminUserDetails(Admin admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
//In Spring Security, implementing UserDetails to wrap your Admin entity is crucial because it allows you to integrate your custom user model (Admin in this case) with Spring Security's authentication and authorization mechanisms. This is necessary for several reasons:
//
//Integration with Spring Security: Spring Security needs to know how to load user-specific data during authentication. By implementing UserDetails, you provide Spring Security with the necessary information about your user (e.g., username, password, roles).
//
//Custom User Data: Your Admin entity might contain additional fields that are specific to your application (e.g., email, phone number). Implementing UserDetails allows you to map these custom fields into the security context.
//
//Role Management: By implementing UserDetails, you can define the roles and authorities that a user has. This is critical for authorization, as Spring Security uses these roles to determine access to different parts of your application.