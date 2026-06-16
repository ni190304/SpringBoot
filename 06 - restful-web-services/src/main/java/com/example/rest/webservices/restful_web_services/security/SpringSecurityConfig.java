package com.example.rest.webservices.restful_web_services.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        

        // All requests must be authenticated
        http.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated()
        );

        // If a request is not authenticated, a web page will be shown, asking for credentials
        http.httpBasic(withDefaults());

        //CSRF -> POST,PUT
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
