package softuni.bg.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.bg.mobilelele.model.binding.UserLoginBindingModel;
import softuni.bg.mobilelele.model.service.UserLoginServiceModel;
import softuni.bg.mobilelele.service.UserService;


@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping()
    public String login(UserLoginBindingModel userLoginBindingModel) {

        userService.login(new UserLoginServiceModel()
                .setUsername(userLoginBindingModel.getUsername())
                .setRawPassword(userLoginBindingModel.getPassword()));

        return "redirect:/index";
    }


}
