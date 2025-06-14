package com.securestack.auth

import com.securestack.domain.Team
import com.securestack.domain.User
import com.securestack.repository.TeamRepository
import com.securestack.repository.UserRepository
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import org.springframework.security.core.authority.SimpleGrantedAuthority

/**
 * Custom OAuth2UserService for handling GitHub logins.
 *
 * Creates a new Team and User if the GitHub user doesn't already exist in the database.
 */
@Service
class GitHubOAuth2UserService(
    private val userRepository: UserRepository,
    private val teamRepository: TeamRepository
) : DefaultOAuth2UserService() {

    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        val oAuth2User = super.loadUser(userRequest)
        val attributes = oAuth2User.attributes

        // Extract GitHub user info
        val githubId = (attributes["id"] as? Int)?.toLong()
            ?: throw IllegalArgumentException("GitHub ID is missing or invalid")

        val username = attributes["login"] as? String
            ?: throw IllegalArgumentException("GitHub login is missing")

        val email = attributes["email"] as? String ?: "$username@users.noreply.github.com"

        // Check if user already exists
        var user = userRepository.findByGithubId(githubId)

        if (user == null) {
            val team = teamRepository.save(Team(name = "$username's Team"))
            user = User(
                githubId = githubId,
                username = username,
                email = email,
                teams = listOf(team) // Wrap the single team in a list
            )
            userRepository.save(user)
        }

        // Return an OAuth2User with basic role (optional enhancement: include user ID or team info)
        return DefaultOAuth2User(
            listOf(SimpleGrantedAuthority("ROLE_USER")),
            attributes,
            "login" // use GitHub's login as the name attribute
        )
    }
}
