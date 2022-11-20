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
        people.add(new Person(++PEOPLE_COUNT, "Nik", 23, "email1"));
        people.add(new Person(++PEOPLE_COUNT, "Tom", 22, "email1"));
        people.add(new Person(++PEOPLE_COUNT, "Bil", 21, "email1"));
        people.add(new Person(++PEOPLE_COUNT, "Sofa", 42, "email1"));
        people.add(new Person(++PEOPLE_COUNT, "Sveta", 14, "email1"));
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

    public void update(int id, Person person) {
        Person personToBeUpdate = getByIdPerson(id);
        personToBeUpdate.setName(person.getName());
        personToBeUpdate.setAge(person.getAge());
        personToBeUpdate.setEmail(person.getEmail());

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
