package com.securestack.repository

import com.securestack.domain.AppDependency
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository for managing AppDependency entities.
 *
 * An AppDependency represents a software dependency used by an application.
 */
interface AppDependencyRepository : JpaRepository<AppDependency, Long>
