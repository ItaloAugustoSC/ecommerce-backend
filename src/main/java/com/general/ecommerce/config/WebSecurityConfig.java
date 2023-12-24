package com.general.ecommerce.config;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

/** Global configuration for application's web security. */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().xssProtection();
        http.csrf().disable();
        http.authorizeHttpRequests().anyRequest().permitAll();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedMethods(
                Arrays.asList("OPTIONS", "HEAD", "GET", "PUT", "POST", "PATCH"));
        http.cors().configurationSource(request -> configuration);
        return http.build();
    }
}

