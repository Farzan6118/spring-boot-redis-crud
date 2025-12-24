package com.example.data.service;

import com.example.data.Controller.dto.request.DepartmentRequestDto;
import com.example.data.Controller.dto.response.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    void deleteById(Long id);

    DepartmentResponseDto update(Long id, DepartmentRequestDto requestDto);

    DepartmentResponseDto create(DepartmentRequestDto requestDto);

    Long countActive();

    DepartmentResponseDto getById(Long id);

    List<DepartmentResponseDto> getAll();
}
