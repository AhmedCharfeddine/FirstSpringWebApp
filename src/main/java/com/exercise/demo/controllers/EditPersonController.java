package com.exercise.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.demo.models.PersonEntity;
import com.exercise.demo.repositories.PersonRepository;

import jakarta.validation.Valid;

@Controller
public class EditPersonController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public ModelAndView getNewPersonForm(@PathVariable("id") Integer id) {
        PersonEntity person = personRepository.findById(id).get();
        ModelAndView modelandview = new ModelAndView("edit_person");
        modelandview.addObject("person", person);
        return modelandview;
    }
    
    @RequestMapping(value = "person/{id}", method = RequestMethod.POST)
    public ModelAndView submitNewPersonForm(@Valid @ModelAttribute("Person") PersonEntity person, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            modelAndView.addObject("person", person);
            modelAndView.setViewName("edit_person");
        }
        else {
            personRepository.save(person);
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
}
