package com.securestack.config

import com.securestack.auth.GitHubOAuth2UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(private val githubOAuth2UserService: GitHubOAuth2UserService) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { authz ->
                authz
                    .requestMatchers("/login", "/css/**").permitAll()
                    .anyRequest().authenticated()
            }
            .oauth2Login { oauth2 ->
                oauth2.userInfoEndpoint()
                    .userService(githubOAuth2UserService)
            }
        return http.build()
    }
}
