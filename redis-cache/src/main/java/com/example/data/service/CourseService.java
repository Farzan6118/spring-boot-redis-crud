package com.example.data.service;

import com.example.data.Controller.dto.request.CourseRequestDto;
import com.example.data.Controller.dto.response.CourseResponseDto;

import java.util.List;

public interface CourseService {
    List<CourseResponseDto> getAll();

    CourseResponseDto getById(Long id);

    Long countActive();

    CourseResponseDto create(CourseRequestDto requestDto);

    CourseResponseDto update(Long id, CourseRequestDto requestDto);

    void deleteById(Long id);
}
