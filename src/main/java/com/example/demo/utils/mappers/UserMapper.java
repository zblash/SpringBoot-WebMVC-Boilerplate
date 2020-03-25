package com.example.demo.utils.mappers;

import com.example.demo.dtos.user.WritableRegister;
import com.example.demo.models.User;

public final class UserMapper {

    public static User writableRegisterToUser(WritableRegister writableRegister) {
        if (writableRegister == null) {
            return null;
        } else {
            User user = new User();
            user.setPassword(writableRegister.getPassword());
            user.setEmail(writableRegister.getEmail());
            user.setFirstName(writableRegister.getFirstName());
            user.setLastName(writableRegister.getLastName());
            user.setUsername(writableRegister.getUsername());
            return user;
        }
    }

}