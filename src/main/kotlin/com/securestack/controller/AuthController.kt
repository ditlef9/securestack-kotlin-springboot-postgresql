package com.securestack.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

/**
 * Handles authentication-related views, such as login and dashboard.
 */
@Controller
class AuthController {

    /**
     * Displays the dashboard page for a logged-in user.
     *
     * @param model      Spring MVC model used to pass attributes to the view.
     * @param oauthUser  The currently authenticated OAuth2 user (from GitHub).
     * @return the name of the Thymeleaf template to render (dashboard.html).
     */
    @GetMapping("/dashboard")
    fun dashboard(
        model: Model,
        @AuthenticationPrincipal oauthUser: OAuth2User
    ): String {
        // Extract GitHub username from OAuth2 attributes and add it to the model
        val username = oauthUser.attributes["login"] as String
        model.addAttribute("username", username)

        return "dashboard"  // maps to templates/dashboard.html
    }

    /**
     * Displays the login page.
     *
     * This endpoint shows the login screen and is not protected by authentication.
     * @return the name of the login template to render (login.html).
     */
    @GetMapping("/login")
    fun login(): String {
        return "login" // maps to templates/login.html
    }
}
