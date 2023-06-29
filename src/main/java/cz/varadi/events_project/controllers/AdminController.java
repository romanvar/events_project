package cz.varadi.events_project.controllers;

import cz.varadi.events_project.services.AdminService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/admin")
    public String dashboardPage(Model model, Authentication authentication) {

//        var events = AdminService.getUserList();
//        model.addAttribute("eventsTempl", events);

        return "admin";
    }
}
