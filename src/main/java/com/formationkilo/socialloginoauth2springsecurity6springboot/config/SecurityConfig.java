package com.formationkilo.socialloginoauth2springsecurity6springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig  {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
            httpSecurity

                    .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                            .requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
                            .anyRequest().authenticated()
                    )
                    .oauth2Login(withDefaults())
                    .formLogin(withDefaults());

            return httpSecurity.build();
        }

}
