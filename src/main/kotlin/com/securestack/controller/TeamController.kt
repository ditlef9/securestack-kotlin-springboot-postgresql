package com.securestack.controller

import com.securestack.service.TeamService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/teams")
class TeamController(
    private val teamService: TeamService
) {
    @GetMapping
    fun listTeams(model: Model): String {
        val teams = teamService.findAll()
        model.addAttribute("teams", teams)
        return "teams/list"
    }
}
