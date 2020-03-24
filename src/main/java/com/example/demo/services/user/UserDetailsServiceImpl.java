package com.example.demo.services.user;

import com.example.demo.models.User;
import com.example.demo.security.CustomPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try{
            User user = userService.findByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return new CustomPrincipal(user);

        }catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

}