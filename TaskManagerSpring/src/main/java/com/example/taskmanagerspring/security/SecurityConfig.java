package com.example.taskmanagerspring.security;

import com.example.taskmanagerspring.service.JWTService;
import com.example.taskmanagerspring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;


@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    private JWTAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JWTService jwtService, UserService userService) {
        this.jwtAuthenticationFilter = new JWTAuthenticationFilter(new JWTAuthenticationManager(jwtService, userService));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrfSpec -> csrfSpec.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/**")
                        .permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        http.addFilterBefore(jwtAuthenticationFilter, AnonymousAuthenticationFilter.class);
        return http.build();
    }
}
