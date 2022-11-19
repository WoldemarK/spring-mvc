package com.example.springmvc.controller;

import com.example.springmvc.dao.PersonDAO;
import com.example.springmvc.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @GetMapping
    public String index(Model model) {
        List<Person> getAll = personDAO.findByAll();
        model.addAttribute("people", getAll);
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Person person = personDAO.getByIdPerson(id);
        model.addAttribute("person", person);
        return "people/show";

    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }
}
