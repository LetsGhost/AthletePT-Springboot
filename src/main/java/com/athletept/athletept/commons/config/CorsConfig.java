package com.athletept.athletept.commons.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebSecurity
public class CorsConfig {

    private static final Logger logger = LoggerFactory.getLogger(CorsConfig.class);

    // Define allowed origins and HTTP methods in one place for easy maintenance
    private static final List<String> ALLOWED_ORIGINS = List.of(
            "http://localhost:3000" // Frontend local address
    );

    private static final List<String> ALLOWED_METHODS = List.of(
            "GET", "POST", "PUT", "DELETE", "OPTIONS"
    );

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(ALLOWED_ORIGINS.toArray(new String[0]))
                        .allowedMethods(ALLOWED_METHODS.toArray(new String[0]))
                        .allowedHeaders("*")
                        .exposedHeaders("Authorization")
                        .allowCredentials(true)
                        .maxAge(3600);

                logger.info("CORS mappings registered for origins: {} and methods: {}",
                        ALLOWED_ORIGINS, ALLOWED_METHODS);
            }
        };
    }

    @PostConstruct
    public void logCorsInit() {
        logger.info("CORS configuration initialized successfully with allowed origins: {}",
                ALLOWED_ORIGINS);
    }
}
