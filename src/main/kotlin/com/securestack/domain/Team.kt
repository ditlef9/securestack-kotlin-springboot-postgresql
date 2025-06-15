/**
 * Represents a development team in the SecureStack system.
 *
 * - `id`: Auto-generated local primary key for the team.
 * - `name`: The display name of the team (e.g., "Platform Engineers").
 * - `users`: List of users that belong to this team.
 *    - This is the inverse side of a many-to-many relationship with `User`.
 *    - Mapped by the `teams` property in the `User` entity.
 */
package com.securestack.domain

import jakarta.persistence.*

@Entity
@Table(name = "teams")
data class Team(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",

    @ManyToMany(mappedBy = "teams")
    val users: List<User> = listOf()
)
