package com.example.data.repository;

import com.example.data.domain.Person;
import com.example.data.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final HashOperations<String, String, Object> hashOps;
    private final ObjectMapper objectMapper;
    private final String KEY;

    public PersonRepositoryImpl(RedisTemplate<String, Object> redisTemplate, ObjectMapper objectMapper) {
        this.hashOps = redisTemplate.opsForHash();
        this.objectMapper = objectMapper;
        this.KEY = "Person";
    }

    @Override
    public Person save(Person person) {
        if (person.getId() != null && hashOps.hasKey(KEY, person.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Person already exists");
        }
        String newId = UUID.randomUUID().toString();
        person.setId(newId);
        person.setCreatedDate(LocalDateTime.now());

        hashOps.put(KEY, person.getId(), person);
        return person;
    }

    @Override
    public Person update(Person person, String id) {
        if (!hashOps.hasKey(KEY, id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }

        Object existing = hashOps.get(KEY, id);
        Person existingPerson = objectMapper.convertValue(existing, Person.class);

        existingPerson.setFirstname(person.getFirstname());
        existingPerson.setLastname(person.getLastname());
        existingPerson.setGender(person.getGender());
        existingPerson.setBirthDate(person.getBirthDate());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setPhoneNumber(person.getPhoneNumber());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setNationalCode(person.getNationalCode());

        existingPerson.setLastModifiedDate(LocalDateTime.now());

        hashOps.put(KEY, existingPerson.getId(), existingPerson);
        return existingPerson;
    }

    @Override
    public Optional<Person> findById(String id) {
        Object obj = hashOps.get(KEY, id);
        return obj == null ? Optional.empty() : Optional.of(objectMapper.convertValue(obj, Person.class));
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(hashOps.entries(KEY)
                .values()
                .stream()
                .map(obj -> objectMapper.convertValue(obj, Person.class))
                .toList());
    }

    @Override
    public void deleteById(String id) {
        hashOps.delete(KEY, id);
    }

    @Override
    public long count() {
        return hashOps.size(KEY);
    }
}