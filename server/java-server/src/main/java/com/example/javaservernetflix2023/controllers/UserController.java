package com.example.javaservernetflix2023.controllers;

import com.example.javaservernetflix2023.datamodel.User;
import com.example.javaservernetflix2023.exceptions.UserNotFoundException;
import com.example.javaservernetflix2023.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    // Register a user with username and password
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = RequestMethod.POST, allowCredentials = "true", maxAge = 3600, exposedHeaders = "*")
    @PostMapping("/register")
    public User register(String username, String password){
        // check if user already exists
        User user = userRepository.getUserbyUsername(username);
        if (user != null) {
            return null;
        } else {
            return userRepository.register(username, password);
        }
    }

    // add role to user
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/add-role")
    public User addRole(String username, String roleName){
        return userRepository.addRole(username, roleName);
    }

    // create a contact
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/add-contact")
    public User addContact(String username, String name, String email, String gender, Date birthDate){
        return userRepository.addContact(username,  name,  email,  gender,  birthDate);
    }

    // create an address
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/add-address")
    public User addAddress(String username, String country, String area, String city, String street, String number){
        return userRepository.addAddress(username, country, area, city, street, number);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) throws UserNotFoundException {
        try {
            User user = userRepository.getUserbyUsername(username);
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new UserNotFoundException("No user is found with username: " + username);
            }
        } catch (Exception e) {
            throw new UserNotFoundException("No user is found with username: " + username);
        }
    }

}
