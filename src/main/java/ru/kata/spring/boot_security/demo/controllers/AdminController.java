package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private RoleRepository roleRepository;

    public AdminController(UserService userService, RoleRepository roleRepository){
        this.userService = userService;
        this.roleRepository = roleRepository;

    }

    @GetMapping
    public String getUserList(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "admin";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "userCreate";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }
}
