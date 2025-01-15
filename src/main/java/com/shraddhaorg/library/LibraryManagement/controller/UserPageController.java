package com.shraddhaorg.library.LibraryManagement.controller;

import com.shraddhaorg.library.LibraryManagement.entities.User;
import com.shraddhaorg.library.LibraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserPageController {

    @Autowired
    private UserService userService;

    // Display all users
    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list"; // Renders templates/user-list.html
    }

    // Show form to add a new user
    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user"; // Renders templates/add-user.html
    }

    // Handle form submission for adding a new user
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users"; // Redirect to user list
    }

    // Delete a user and return to the list
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
