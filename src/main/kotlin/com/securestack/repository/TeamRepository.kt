package com.securestack.repository

import com.securestack.domain.*
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository for managing Team entities.
 *
 * Each team can have multiple users and own multiple apps.
 */
interface TeamRepository : JpaRepository<Team, Long>
