package com.spring.spring_boot_CRUD.repository;

import com.spring.spring_boot_CRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
}