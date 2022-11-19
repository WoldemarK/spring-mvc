package com.example.springmvc.dao;

import com.example.springmvc.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Nik"));
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bil"));
        people.add(new Person(++PEOPLE_COUNT, "Sofa"));
        people.add(new Person(++PEOPLE_COUNT, "Sveta"));
    }

    public List<Person> findByAll() {
        return people;
    }

    public Person getByIdPerson(int id) {
        return people.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
