package cz.varadi.events_project.controllers;

import cz.varadi.events_project.dto.UserLoginDto;
import cz.varadi.events_project.entities.UserEntity;
import cz.varadi.events_project.exceptions.UserNotFoundException;
import cz.varadi.events_project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
//        var user = userService.findByEmail(model.)
        return "login";
    }

}








