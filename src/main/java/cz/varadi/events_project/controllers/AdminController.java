package cz.varadi.events_project.controllers;

import cz.varadi.events_project.dto.UserDto;
import cz.varadi.events_project.entities.UserEntity;
import cz.varadi.events_project.services.AdminServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

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
    public String getUserPage(@PathVariable("id") Long id, Model model, Authentication authentication) {
        var user = adminService.getUser(id);
        model.addAttribute("user", user);
        var roles = adminService.getAllRoles();
        model.addAttribute("roles", roles);
        return "change-user";
    }

    @PostMapping("/admin/{id}")
    public String changeUserPage(@ModelAttribute("user") @Valid UserDto userDto, WebRequest request, Long id, Model model) {
        try {

            UserEntity user = adminService.changeUserAccount(userDto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "change_confirmation";
    }
}
