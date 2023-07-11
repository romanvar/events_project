package cz.varadi.events_project.controllers;

import cz.varadi.events_project.dto.UserChangeDto;
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
        var users = adminService.getUser(id);
        model.addAttribute("user", users);
        return "change-user";
    }

    @PostMapping("/admin/{id}")
    public String changeUserPage(@ModelAttribute("user") @Valid UserChangeDto userChangeDto, WebRequest request, Long id, Model model) {
        try {
            System.out.println("Post Mapping - changeUserPage");
            UserEntity user = adminService.changeUserAccount(userChangeDto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "change-user";
    }
}
