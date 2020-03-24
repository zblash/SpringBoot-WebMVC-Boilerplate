package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String Register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        model.addAttribute("user", user);

        if (result.hasErrors()){
            return "register";
        } else {
            userService.create(user);

        }
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
}
