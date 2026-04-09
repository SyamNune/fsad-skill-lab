package com.example.jwtauth.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.jwtauth.security.JwtFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll()
                .requestMatchers("/h2-console/**").permitAll()   // ✅ ADD THIS
                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                .requestMatchers("/employee/**").hasAuthority("EMPLOYEE")
                .anyRequest().authenticated()
            )
            .headers(headers -> headers.frameOptions().disable()) // ✅ ADD THIS
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    }
