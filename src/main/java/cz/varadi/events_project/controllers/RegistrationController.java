package cz.varadi.events_project.controllers;


import cz.varadi.events_project.dto.UserRegisterDto;
import cz.varadi.events_project.entities.UserEntity;
import cz.varadi.events_project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        model.addAttribute("user", userRegisterDto);
        return "registration";
    }


    @PostMapping("/user/registration")
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserRegisterDto userRegisterDto,
            WebRequest request, Model model) {

        try {
            UserEntity registered = userService.registerNewUserAccount(userRegisterDto);
        } catch (Exception uaeEx) {
            model.addAttribute("message", "An account for that username/email already exists.");
            return "registration";
        }

        return "redirect:/login";

    }


}
