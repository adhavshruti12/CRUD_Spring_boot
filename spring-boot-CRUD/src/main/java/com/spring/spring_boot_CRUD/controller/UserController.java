package com.spring.spring_boot_CRUD.controller;

import com.spring.spring_boot_CRUD.entity.User;
import com.spring.spring_boot_CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        System.out.println("Received user: " + user);
        return service.saveUser(user);
    }
    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        return service.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }
    @GetMapping("/userById/{id}")
    public User findById(@PathVariable int id){
        return service.getUserById(id);
    }
    @GetMapping("/userByName/{name}")
    public User findByName(@PathVariable String name){
        return service.getUserByName(name);
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteById(id);
    }
}
