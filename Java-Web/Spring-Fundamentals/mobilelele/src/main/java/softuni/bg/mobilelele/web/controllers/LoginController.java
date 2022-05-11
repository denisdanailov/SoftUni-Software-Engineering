package softuni.bg.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.mobilelele.model.binding.UserLoginBindingModel;
import softuni.bg.mobilelele.model.service.UserLoginServiceModel;
import softuni.bg.mobilelele.service.UserService;

import javax.validation.Valid;


@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(Model model) {

        if (!model.containsAttribute("isFound")) {
            model.addAttribute("isFound",true);
        }

        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:/login";
        }

        UserLoginServiceModel userLoginServiceModel =
                userService.findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (userLoginServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("isFound", false);

            return "redirect:/login";
        }

        userService.login(userLoginServiceModel.getId(), userLoginBindingModel.getUsername());

                return "redirect:/";
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }


}
