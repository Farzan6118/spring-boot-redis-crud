package com.example.data.mapper;

import com.example.data.Controller.dto.request.PersonRequestDto;
import com.example.data.Controller.dto.response.PersonResponseDto;
import com.example.data.domain.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonResponseDto toDto(Person person);

    Person toEntity(PersonRequestDto requestDto);
}