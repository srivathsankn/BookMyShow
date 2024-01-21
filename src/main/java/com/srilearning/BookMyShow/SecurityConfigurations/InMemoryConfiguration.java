package com.srilearning.BookMyShow.SecurityConfigurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class InMemoryConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){


        UserDetails srivathsan = User.builder()
                .username("srivathsan")
                .password(("{noop}test123"))
                .roles("CUSTOMER", "RECEPTIONIST", "ADMIN").build();

        UserDetails operator = User.builder()
                .username("operator")
                .password(("{noop}operator"))
                .roles( "RECEPTIONIST").build();

        UserDetails customer = User.builder()
                .username("customer")
                .password(("{noop}customer"))
                .roles("CUSTOMER").build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(("{noop}admin"))
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(srivathsan, operator, customer, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.POST, "/actor").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/movie").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/user").hasRole( "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/user/**").hasAnyRole( "RECEPTIONIST","ADMIN")
                        .requestMatchers(HttpMethod.POST, "/ticket").hasAnyRole("CUSTOMER", "RECEPTIONIST","ADMIN")
       );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}
