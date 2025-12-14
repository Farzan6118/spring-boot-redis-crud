package com.example.data.service;

import com.example.data.Controller.dto.request.PersonRequestDto;
import com.example.data.Controller.dto.response.PersonResponseDto;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    List<PersonResponseDto> getAll();

    PersonResponseDto update(PersonRequestDto requestDto, UUID id);

    PersonResponseDto getById(UUID id);

    PersonResponseDto create(PersonRequestDto requestDto);

    void delete(UUID id);

    long count();

}
