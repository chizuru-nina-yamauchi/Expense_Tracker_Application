package com.example.expense_tracker_application.controller;


import com.example.expense_tracker_application.model.User;
import com.example.expense_tracker_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    @GetMapping("/new")
    public String showUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-form";
    }
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        userService.createUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }


    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user, Model model) {
        userService.updateUser(id, user);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/users";
    }



}
