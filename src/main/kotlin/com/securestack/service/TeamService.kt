package com.securestack.service

import com.securestack.domain.Team
import com.securestack.repository.TeamRepository
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository
) {

    /**
     * Returns all teams in the system.
     */
    fun findAll(): List<Team> = teamRepository.findAll()

    /**
     * Returns a team by its ID, or null if not found.
     */
    fun findById(id: Long): Team? = teamRepository.findById(id).orElse(null)

    /**
     * Creates or updates a team.
     */
    fun save(team: Team): Team = teamRepository.save(team)

    /**
     * Deletes a team by its ID.
     */
    fun deleteById(id: Long) = teamRepository.deleteById(id)
}
