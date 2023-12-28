package com.srilearning.BookMyShow.Controllers;
import com.srilearning.BookMyShow.Exceptions.UserNotAvailableException;
import com.srilearning.BookMyShow.Models.User;
import com.srilearning.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers()
    {
        //return "All Users";
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable long userId) throws UserNotAvailableException
    {
        //return "All Users";
        return userService.getUser(userId);
    }

}
