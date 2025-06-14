package com.securestack.repository

import com.securestack.domain.*
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository for managing App entities.
 *
 * An App represents a codebase or project owned by a team.
 */
interface AppRepository : JpaRepository<App, Long>
