package com.securestack.controller

import com.securestack.domain.App
import com.securestack.domain.Team
import com.securestack.service.AppService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/apps")
class AppController(
    private val appService: AppService
) {

    @GetMapping
    fun listApps(model: Model): String {
        val apps = appService.findAll()
        model.addAttribute("apps", apps)
        return "apps/list"  // maps to templates/apps/list.html
    }

    @GetMapping("/{id}")
    fun showApp(@PathVariable id: Long, model: Model): String {
        val app = appService.findById(id) ?: return "redirect:/apps"
        model.addAttribute("app", app)
        return "apps/detail" // maps to templates/apps/detail.html
    }


    @GetMapping("/create")
    fun showCreateForm(model: Model): String {
        model.addAttribute("app", App(name = "", team = Team(name="")))  // Dummy team for binding
        model.addAttribute("teams", appService.findAllTeams())    // Add available teams
        return "apps/create"
    }

    @PostMapping
    fun createApp(
        @RequestParam name: String,
        @RequestParam teamId: Long
    ): String {
        val team = appService.findTeamById(teamId)
            ?: return "redirect:/apps/create?error=teamNotFound"

        val app = App(name = name, team = team)
        appService.createApp(app)
        return "redirect:/apps"
    }
}
