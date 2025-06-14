package com.securestack.domain

import jakarta.persistence.*

/**
 * Represents an application/project managed by a team.
 *
 * - `id`: Auto-generated primary key.
 * - `name`: The app’s name (e.g., "SecureStack Backend").
 * - `team`: The team that owns this app (many apps can belong to one team).
 * - `dependencies`: The list of software dependencies used by this app.
 *    - One app can have many dependencies.
 *    - Mapped by the "app" field in the AppDependency entity.
 */
@Entity
@Table(name = "apps")
data class App(
    @Id @GeneratedValue
    val id: Long = 0,

    val name: String,

    @ManyToOne
    val team: Team,

    @OneToMany(mappedBy = "app")
    val dependencies: List<AppDependency> = listOf()
)
