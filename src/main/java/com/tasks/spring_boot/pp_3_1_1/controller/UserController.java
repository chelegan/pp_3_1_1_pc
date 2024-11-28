package com.tasks.spring_boot.pp_3_1_1.controller;

import com.tasks.spring_boot.pp_3_1_1.model.User;
import com.tasks.spring_boot.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getListOfAllUsers());
        return "usersIndex";
    }

    @GetMapping(value = "/addUser")
    public String getFormForAddUser(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping(value = "/users")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String getFormForUpdateUser(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("user", userService.getUser(id));
        return "updateUser";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {

        userService.updateUser(user);
        return "redirect:/users";
    }
}
