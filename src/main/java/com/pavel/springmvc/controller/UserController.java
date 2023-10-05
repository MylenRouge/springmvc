package com.pavel.springmvc.controller;

import com.pavel.springmvc.model.User;
import com.pavel.springmvc.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String showSingleUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.showUsers(id));
        return "show";
    }

    @GetMapping("/new")
    public String showNewUserPage(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.saveUsers(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("userDelete", userService.showUsers(id));
        return "redirect:/";
    }
}
