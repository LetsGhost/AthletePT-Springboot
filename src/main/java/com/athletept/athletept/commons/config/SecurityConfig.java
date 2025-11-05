package com.athletept.athletept.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("!dev")
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   DaoAuthenticationProvider provider) throws Exception {
        http
                .authenticationProvider(provider)

                // Session-based auth (needed for JSESSIONID)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))

                // Keep CSRF ON for session/cookie flows, but ignore it for login/logout if you want simpler clients
                .csrf(csrf -> csrf.ignoringRequestMatchers(
                        "/api/v1/auth/login",
                        "/api/v1/auth/logout"
                ))
                // If you'd rather require CSRF for login, remove the ignoring... and fetch token from /api/v1/auth/csrf

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/actuator/health", "/actuator/info",
                                "/api/v1/auth/login",       // <— not protected
                                "/api/v1/auth/logout",      // <— not protected
                                "/api/v1/auth/csrf",        // CSRF token fetch
                                "/api/v1/auth/me",          // optional to expose even if unauthenticated
                                "/error"
                        ).permitAll()
                        .anyRequest().authenticated()
                )

                .httpBasic(b -> b.disable())
                .formLogin(f -> f.disable());

        return http.build();
    }
}
