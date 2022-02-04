package com.prSecurity.controllers;

import com.prSecurity.service.UsersRepository;
import com.prSecurity.service.UsersService;
import com.prSecurity.Status;
import com.prSecurity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UsersController {
    UsersRepository userRepository;
    UsersService userService;

    @Autowired
    public UsersController(UsersService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.getUserFromRepo(id);
        if (user == null ) {
            user = new User();
            user.setName("User not found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users/register")
    public ResponseEntity<Long> createUser(@RequestBody User user) {
        long createId = userService.insertUserIntoRepo(user);
        return new ResponseEntity<>(createId, HttpStatus.CREATED);
    }


    @PostMapping("/users/login")
    public String loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                return "logForm";
            }
        }
        return "logForm";
    }
    @GetMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }

    @PostMapping("/users/register")
    public String showUserRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "logForm";
    }
/*
      @GetMapping("/users/register")
    public String showUsersAddForm(Model model) {
        model.addAttribute("user", new User());
        return "logForm";
    }
    @PostMapping("/users/register")
    public String submitUserAddForm (@ModelAttribute User user, Model model) {
        userService.insertUserIntoRepo(user);
        model.addAttribute( "user", new User());
        return "logForm";
    }

 */
}