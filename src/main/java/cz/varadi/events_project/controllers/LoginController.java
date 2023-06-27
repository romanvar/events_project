package cz.varadi.events_project.controllers;

import cz.varadi.events_project.dto.UserLoginDto;
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
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") @Valid UserLoginDto userLoginDto,
                            WebRequest request, Model model) {

        try {

            boolean userLogged = userService.loginUser(userLoginDto);
           if (userLogged  == true) {
               return "redirect:/dashboard";
           }else{
               throw new Exception("Not Logged in") ;
           }

        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/login?error";
        }

    }

}








