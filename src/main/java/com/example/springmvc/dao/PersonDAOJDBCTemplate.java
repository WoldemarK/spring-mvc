package com.example.springmvc.dao;

import com.example.springmvc.mapper.PersonMapper;
import com.example.springmvc.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PersonDAOJDBCTemplate {

    private final JdbcTemplate jdbcTemplate;

    public List<Person> index() {
        return jdbcTemplate.query("select * from person", (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setAge(rs.getInt("age"));
            person.setEmail(rs.getString("email"));
            return person;
        });
    }

    public Person show(int id) {
        return jdbcTemplate.query("select * from person where id=?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream()
                .findAny()
                .orElse(null);

    }

    public Person showV2(int id) {
        return jdbcTemplate.query("select * from person where id=?",
                        new Object[]{id},
                        new PersonMapper())
                .stream()
                .findAny()
                .orElse(null);

    }

    public void save(Person person) {
        jdbcTemplate.update("insert into person values (1,?,?,?)",
                person.getName(),
                person.getAge(),
                person.getEmail());
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE person set name=?, agr=?, email=? where id=?",
                person.getName(),
                person.getAge(),
                person.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from person where id=?", id);
    }
}
