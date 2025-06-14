/**
 * Represents an authenticated user in the SecureStack system.
 *
 * - `id`: Local auto-generated primary key.
 * - `githubId`: The user's GitHub ID from OAuth; used to identify the same user across sessions.
 * - `username`: GitHub username (e.g., "johndoe").
 * - `email`: User's email address (may be GitHub public email or a fallback).
 * - `teams`: A list of teams this user belongs to.
 *     - Many-to-many relationship managed via a join table named `user_team`.
 *     - Each user can belong to multiple teams; each team can have multiple users.
 */
package com.securestack.domain

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val githubId: Long,
    val username: String,
    val email: String,

    @ManyToMany
    @JoinTable(
        name = "user_team",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "team_id")]
    )
    val teams: List<Team> = listOf()
)
