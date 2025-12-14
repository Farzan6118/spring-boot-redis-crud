package com.example.data.service.impl;

import com.example.data.Controller.dto.request.PersonRequestDto;
import com.example.data.Controller.dto.response.PersonResponseDto;
import com.example.data.domain.Person;
import com.example.data.mapper.PersonMapper;
import com.example.data.repository.impl.PersonRepositoryImpl;
import com.example.data.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepositoryImpl repository;
    private final PersonMapper personMapper;

    @Override
    public PersonResponseDto create(PersonRequestDto requestDto) {
        Person personEntity = personMapper.toEntity(requestDto);
        Person savedPerson = repository.save(personEntity);
        return personMapper.toDto(savedPerson);
    }

    @Override
    public PersonResponseDto update(PersonRequestDto requestDto, UUID id) {
        Person personEntity = personMapper.toEntity(requestDto);
        Person savedPerson = repository.update(personEntity, String.valueOf(id));
        return personMapper.toDto(savedPerson);
    }

    @Override
    public PersonResponseDto getById(UUID id) {
        Person personEntity = repository.findById(String.valueOf(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"));
        return personMapper.toDto(personEntity);
    }

    @Override
    public List<PersonResponseDto> getAll() {
        List<Person> allPeople = repository.findAll();
        return allPeople.stream().map(personMapper::toDto).toList();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id.toString());
    }

    @Override
    public long count() {
        return repository.count();
    }
}
