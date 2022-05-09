package softuni.bg.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping("/test")
        public ModelAndView test(ModelAndView modelAndView, @RequestParam(value = "name", defaultValue = "Anonymous") String name) {

        modelAndView.addObject("name",name);
        modelAndView.setViewName("test");
            return modelAndView;
        }

}
