package com.exercise.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.demo.DTO.RegistrationDto;
import com.exercise.demo.models.UserEntity;
import com.exercise.demo.service.UserService;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterPage() {
        RegistrationDto user = new RegistrationDto();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute("user") RegistrationDto user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity existingUser = userService.findByLogin(user.getLogin());
        if(existingUser != null && existingUser.getLogin() != null && !existingUser.getLogin().isEmpty()) {
            System.out.println("already existing");
            modelAndView.setViewName("redirect:/register?failure");
        }
        else {
            if (bindingResult.hasErrors()) {
                System.out.println(bindingResult.getAllErrors());
                modelAndView.addObject("user", user);
                modelAndView.setViewName("redirect:/register?failure");
            }
            else {
                userService.saveUser(user);
                modelAndView.setViewName("redirect:/login?register_success");
            }
        }
        return modelAndView;
    }
}
