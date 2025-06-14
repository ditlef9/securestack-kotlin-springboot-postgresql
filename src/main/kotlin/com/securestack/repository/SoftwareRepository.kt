package com.securestack.repository

import com.securestack.domain.*
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository for managing Software entities.
 *
 * Software refers to general tools or platforms used by teams (e.g., Java, Git, IntelliJ).
 */
interface SoftwareRepository : JpaRepository<Software, Long>
