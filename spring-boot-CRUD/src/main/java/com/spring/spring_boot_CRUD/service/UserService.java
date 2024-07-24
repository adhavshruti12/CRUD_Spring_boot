package com.spring.spring_boot_CRUD.service;

import com.spring.spring_boot_CRUD.entity.User;
import com.spring.spring_boot_CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }
    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }
    public User getUserById(int id){
        return repository.findById(id).orElse(null);

    }
    public User getUserByName(String name){
        return repository.findByName(name);

    }

    public String deleteById(int id){
        repository.deleteById(id);
        return "User removed successfully!" +id;
    }

    public User updateUser(User user){
        User existingUser=repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setPhoneno(user.getPhoneno());
        return repository.save(existingUser);
    }
}
