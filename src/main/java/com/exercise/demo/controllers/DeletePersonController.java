package com.exercise.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exercise.demo.repositories.PersonRepository;

@Controller
public class DeletePersonController {
    @Autowired
    private PersonRepository personRepository;
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String deletePerson(@PathVariable("id") Integer id) {
        if (personRepository.existsById(id)){
            personRepository.deleteById(id);
        }
        return "redirect:/";
    }
}
