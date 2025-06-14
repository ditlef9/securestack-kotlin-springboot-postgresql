package com.securestack.domain

import jakarta.persistence.*

/**
 * Represents a software dependency used by an application.
 *
 * - `id`: Auto-generated primary key.
 * - `groupId`: The group or organization ID of the dependency (e.g., "org.jetbrains.kotlin").
 * - `artifactId`: The artifact or library name (e.g., "kotlin-stdlib").
 * - `currentVersion`: The version currently used by the application.
 * - `latestVersion`: The latest available version (for update monitoring).
 * - `application`: The application that owns this dependency.
 *    - Many dependencies belong to one application.
 *    - Foreign key column is "application_id".
 */
@Entity
@Table(name = "apps_dependencies")
data class AppDependency(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val groupId: String,
    val artifactId: String,
    val currentVersion: String,
    val latestVersion: String,

    @ManyToOne
    @JoinColumn(name = "app_id")
    val app: App
)
