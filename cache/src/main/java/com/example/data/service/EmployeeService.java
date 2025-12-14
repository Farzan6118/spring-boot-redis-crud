package com.example.data.service;

import com.example.data.Controller.dto.request.EmployeeRequestDto;
import com.example.data.Controller.dto.response.EmployeeResponseDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeResponseDto> getAll();

    EmployeeResponseDto getById(Long id);

    EmployeeResponseDto update(EmployeeRequestDto requestDto, Long id);

    Optional<EmployeeResponseDto> findById(Long id);

    EmployeeResponseDto create(EmployeeRequestDto requestDto);

    void delete(Long id);

    long count();

}
