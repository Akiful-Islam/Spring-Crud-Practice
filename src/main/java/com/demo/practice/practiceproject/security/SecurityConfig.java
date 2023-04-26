package com.demo.practice.practiceproject.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}test")
                .roles("Regular")
                .build();
        UserDetails info = User.builder()
                .username("info")
                .password("{noop}test")
                .roles("Info")
                .build();
        UserDetails hr = User.builder()
                .username("hr")
                .password("{noop}test")
                .roles("HR")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}test")
                .roles("Admin")
                .build();
        return new InMemoryUserDetailsManager(user, info, hr, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String employeeEndPoint = "/api/employees";
        String employeeEndPointWithId = employeeEndPoint +"/**";
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.GET,employeeEndPoint).hasAnyRole("Info" ,"HR", "Admin")
                .requestMatchers(HttpMethod.GET, employeeEndPointWithId).hasAnyRole("Regular","Info" ,"HR", "Admin")
                .requestMatchers(HttpMethod.POST, employeeEndPoint).hasAnyRole( "HR", "Admin")
                .requestMatchers(HttpMethod.PUT, employeeEndPointWithId).hasAnyRole("Info", "HR", "Admin")
                .requestMatchers(HttpMethod.DELETE, employeeEndPointWithId).hasRole("Admin")
        );

        http.httpBasic();
        http.csrf().disable();
        return http.build();
    }
}
