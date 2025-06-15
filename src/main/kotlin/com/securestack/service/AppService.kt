package com.securestack.service

import com.securestack.domain.App
import com.securestack.domain.Team
import com.securestack.repository.AppRepository
import com.securestack.repository.TeamRepository
import org.springframework.stereotype.Service

@Service
class AppService(
    private val appRepository: AppRepository,
    private val teamRepository: TeamRepository
) {

    fun findAll(): List<App> = appRepository.findAll()

    fun findById(id: Long): App? = appRepository.findById(id).orElse(null)

    fun createApp(app: App): App = appRepository.save(app)

    fun deleteApp(id: Long) = appRepository.deleteById(id)

    fun findAllTeams(): List<Team> = teamRepository.findAll()

    fun findTeamById(id: Long): Team? = teamRepository.findById(id).orElse(null)

}
