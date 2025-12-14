package com.example.data.repository;

import com.example.data.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository {
    Person save(Person person);

    Person update(Person person, String id);

    Optional<Person> findById(String id);

    List<Person> findAll();

    void deleteById(String id);

    long count();
}
