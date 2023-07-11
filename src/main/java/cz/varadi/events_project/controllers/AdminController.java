package cz.varadi.events_project.controllers;

import cz.varadi.events_project.services.AdminService;
import cz.varadi.events_project.services.AdminServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    private final AdminServiceImpl adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/admin")
    public String adminPage(Model model, Authentication authentication) {

        var users = adminService.getUserList();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/admin/{id}")
    public String getUserPage(@PathVariable("id") Integer id, Model model, Authentication authentication) {
        var users = adminService.getUser(id);
        model.addAttribute("user", users);
        return "change-user";
    }

    @PostMapping("/admin/{id}")
    public String changeUserPage(Integer id, Model model, Authentication authentication) {

        return "change-user";
    }
}
