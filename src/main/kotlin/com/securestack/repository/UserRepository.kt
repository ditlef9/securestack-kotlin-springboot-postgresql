package com.securestack.repository

import com.securestack.domain.*
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository for managing User entities.
 *
 * Provides CRUD operations and a custom finder method to locate a user by GitHub username.
 */
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun findByGithubId(githubId: Long): User?
}
