package com.example.data.service;

import com.example.data.Controller.dto.request.ProfessorRequestDto;
import com.example.data.Controller.dto.response.ProfessorResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProfessorService {
    @Transactional
    ProfessorResponseDto create(ProfessorRequestDto requestDto);

    @Transactional
    ProfessorResponseDto getById(Long id);

    @Transactional
    List<ProfessorResponseDto> getAll();

    @Transactional
    ProfessorResponseDto update(Long id, ProfessorRequestDto requestDto);

    @Transactional
    void deleteById(Long id);

    @Transactional
    Long countActive();
}
