package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String printWelcome(ModelMap modelMap) {
        String hello = "Welcome to my page!";
        modelMap.addAttribute("hello", hello);
        return "users/hello";
    }
}
