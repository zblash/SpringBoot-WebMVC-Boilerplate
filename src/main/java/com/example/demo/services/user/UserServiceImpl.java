package com.example.demo.services.user;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BadRequestException("User not found"));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new BadRequestException("User not found"));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new BadRequestException("User not found"));
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User updatedUser) {
        User user = findById(id);
        user.setEmail(updatedUser.getEmail());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setUsername(updatedUser.getUsername());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User changePassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        return update(user.getId(),user);
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public boolean canRegister(User user){
        return !userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail()).isPresent();
    }
}
