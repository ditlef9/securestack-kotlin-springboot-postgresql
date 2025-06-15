package com.securestack.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/",
                        "/login",
                        "/css/**",
                        "/js/**",
                        "/images/securestack-magpie-16x16.png",
                        "/images/securestack-magpie-32x32.png",
                        "/images/securestack-magpie-128x128.png",
                        "/images/securestack-magpie-256x256.png",
                        "/images/login-bg.jpg",
                        "/icons/20x20/svg/github-black-20x20.svg",
                        "/login.css",
                        "/global.css",
                        "/favicon.ico").permitAll()
                    .anyRequest().authenticated()
            }
            .oauth2Login { oauth ->
                oauth
                    .loginPage("/login")
                    .defaultSuccessUrl("/dashboard", true)
            }
            .logout { logout ->
                logout
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
            }

        return http.build()
    }
}
