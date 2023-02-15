package com.exercise.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.demo.models.UserEntity;
import com.exercise.demo.repositories.PersonRepository;
import com.exercise.demo.repositories.UserRepository;
import com.exercise.demo.security.SecurityUtil;

@Controller
public class IndexController {

    @Autowired // get the bean called "userRepository" (auto-generated)
    private PersonRepository personRepository; // Used to handle the data
    
    @Autowired
    private UserRepository userRepository;

    public String[] CIVILITE = {"M.", "Mme.", "Mlle."};
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelandview = new ModelAndView();
        UserEntity curUser = userRepository.findFirstByLogin(SecurityUtil.getSessionUser());
        modelandview.addObject("user", curUser);
        modelandview.addObject("people", personRepository.findAll());
        modelandview.addObject("CIVILITE", CIVILITE);
        modelandview.setViewName("index");
        return modelandview;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("fname_search") String fname, @RequestParam("lname_search") String lname, @RequestParam("civilite_search") Integer civilite) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity curUser = userRepository.findFirstByLogin(SecurityUtil.getSessionUser());
        modelAndView.addObject("user", curUser);
        modelAndView.addObject("people", personRepository.searchQuery(fname, lname, civilite));
        modelAndView.addObject("CIVILITE", CIVILITE);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}