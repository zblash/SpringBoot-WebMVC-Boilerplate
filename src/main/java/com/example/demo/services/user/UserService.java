package com.example.demo.services.user;

import com.example.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User findByEmail(String email);

    User findByUsername(String username);

    User create(User user);

    User update(Long id, User updatedUser);

    User changePassword(User user, String password);

    User delete(User user);

    boolean canRegister(User user);
}
