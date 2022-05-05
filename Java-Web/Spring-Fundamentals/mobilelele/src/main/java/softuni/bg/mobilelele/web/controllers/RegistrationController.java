package softuni.bg.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.bg.mobilelele.model.binding.UserRegistrationBindingModel;

@Controller
public class RegistrationController {

    @GetMapping("users/register")
    public String registerUser() {
        return "auth-register";
    }

    @PostMapping("users/register")
    public  String register(UserRegistrationBindingModel userModel) {
        return "redirect:/";
    }
}
