package softuni.bg.mobilelele.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.mobilelele.model.binding.UserRegistrationBindingModel;
import softuni.bg.mobilelele.model.service.UserRegistrationServiceModel;
import softuni.bg.mobilelele.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public RegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("userModel")
    public UserRegistrationBindingModel userModel() {
        return new UserRegistrationBindingModel();
    }

    @GetMapping("users/register")
    public String registerUser() {
        return "auth-register";
    }

    @PostMapping("users/register")
    public  String register(@Valid UserRegistrationBindingModel userModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors() || !userModel.getPassword().equals(userModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);


            return "redirect:register";
        }

        UserRegistrationServiceModel serviceModel = modelMapper.map(userModel, UserRegistrationServiceModel.class);

        userService.registerUser(serviceModel);

        return "redirect:login/";
    }
}



