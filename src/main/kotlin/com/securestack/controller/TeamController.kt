package com.securestack.controller

import com.securestack.domain.Team
import com.securestack.service.TeamService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/create")
    fun showCreateForm(model: Model): String {
        model.addAttribute("team", Team(name = ""))
        return "teams/create"
    }

    @PostMapping
    fun createTeam(@ModelAttribute team: Team): String {
        teamService.save(team)
        return "redirect:/teams"
    }
}
