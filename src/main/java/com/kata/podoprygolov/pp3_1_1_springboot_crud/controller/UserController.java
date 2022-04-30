package com.kata.podoprygolov.pp3_1_1_springboot_crud.controller;

import com.kata.podoprygolov.pp3_1_1_springboot_crud.model.User;
import com.kata.podoprygolov.pp3_1_1_springboot_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String start() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        model.addAttribute("users", service.findAll());
        return "/users";
    }

    @GetMapping("/user/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", service.findByID(id));
        return "/user";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "/user-create";
    }

    @PostMapping("/user-create")
    public String saveUser(User user) {
        service.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String userUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", service.findByID(id));
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String userUpdate(User user) {
        service.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String userDelete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/users";
    }
}
