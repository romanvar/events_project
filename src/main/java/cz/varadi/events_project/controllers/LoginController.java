package cz.varadi.events_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@RequestParam String username, @RequestParam String password) {
        // TODO: Implement your login logic here

        if (username.equals("admin") && password.equals("password")) {
            return "redirect:/dashboard";
        } else {
            return "redirect:/login?error";
        }
    }
}








