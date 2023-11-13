package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getUserList();
    User getUser(Long id);
    void addUser(User user);
    void editUser(User user);
    void deleteUser(Long id);
    User findByUsername(String username);

}
