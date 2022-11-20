package com.example.springmvc.controller;

import com.example.springmvc.dao.PersonDAOJDBC;
import com.example.springmvc.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/jdbc")
public class PeopleControllerJDBC {

    private final PersonDAOJDBC personDAOJDBC;

    @GetMapping("/api")
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personDAOJDBC.index());
    }
    @GetMapping("/api/{id}")
    public ResponseEntity<Person>getId(@PathVariable("id") int id){
        return ResponseEntity.ok(personDAOJDBC.show(id));
    }
}
