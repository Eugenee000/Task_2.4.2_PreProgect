package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/{id}/edit")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String upDate(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
}
