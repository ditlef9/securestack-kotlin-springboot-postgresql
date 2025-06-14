package com.securestack.domain

import jakarta.persistence.*

/**
 * Represents a software tool or product used by teams.
 *
 * Examples: Git, Java JDK, IntelliJ IDEA, Kotlin compiler.
 *
 * Tracks the current installed version and latest available version
 * to help teams stay up-to-date and secure.
 *
 * - `id`: Auto-generated primary key.
 * - `name`: The software tool's name.
 * - `currentVersion`: The version currently used by the team.
 * - `latestVersion`: The latest available version.
 */
@Entity
@Table(name = "software")
data class Software(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val currentVersion: String,

    val latestVersion: String
)
