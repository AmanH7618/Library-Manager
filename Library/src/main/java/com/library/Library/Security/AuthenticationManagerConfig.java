package com.library.Library.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import java.util.Arrays;

@Configuration
public class AuthenticationManagerConfig {

    private final DaoAuthenticationProvider personAuthenticationProvider;
    private final DaoAuthenticationProvider adminAuthenticationProvider;

    public AuthenticationManagerConfig(DaoAuthenticationProvider personAuthenticationProvider,
                                       DaoAuthenticationProvider adminAuthenticationProvider) {
        this.personAuthenticationProvider = personAuthenticationProvider;
        this.adminAuthenticationProvider = adminAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(personAuthenticationProvider, adminAuthenticationProvider));
    }
}
