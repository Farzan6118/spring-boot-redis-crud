package com.example.data.service;

import com.example.data.Controller.dto.request.EnrollmentRequestDto;
import com.example.data.Controller.dto.response.EnrollmentResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EnrollmentService {
    @Transactional
    EnrollmentResponseDto create(EnrollmentRequestDto requestDto);

    @Transactional
    EnrollmentResponseDto getById(Long id);

    @Transactional
    List<EnrollmentResponseDto> getAll();

    @Transactional
    EnrollmentResponseDto update(Long id, EnrollmentRequestDto requestDto);

    @Transactional
    void deleteById(Long id);

    @Transactional
    Long countActive();
}
