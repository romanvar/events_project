package cz.varadi.events_project.controllers;

import cz.varadi.events_project.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DashboardController {
    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public String dashboardPage(Model model,  Authentication authentication) {

        var events = dashboardService.getMyEvents( ((UserDetails) authentication.getPrincipal()).getUsername());
                model.addAttribute("eventsTempl", events);

        return "dashboard";

    }


}
