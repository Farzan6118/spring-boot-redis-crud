package com.example.data.service;

import com.example.data.Controller.dto.request.StudentRequestDto;
import com.example.data.Controller.dto.response.StudentResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface StudentService {
    @Transactional
    StudentResponseDto create(StudentRequestDto requestDto);

    @Transactional
    StudentResponseDto getById(Long id);

    @Transactional
    List<StudentResponseDto> getAll();

    @Transactional
    StudentResponseDto update(Long id, StudentRequestDto requestDto);

    @Transactional
    void deleteById(Long id);

    @Transactional
    Long countActive();

}
