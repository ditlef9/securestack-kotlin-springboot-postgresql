package com.securestack.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AuthController {

    @GetMapping("/dashboard")
    fun dashboard(
        model: Model,
        @AuthenticationPrincipal oauthUser: OAuth2User
    ): String {
        val username = oauthUser.attributes["login"] as String
        model.addAttribute("username", username)
        return "dashboard"
    }

    @GetMapping("/login")
    fun login(): String = "login"
}
