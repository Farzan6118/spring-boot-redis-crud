package com.example.data.service.impl;

import com.example.data.mapper.ProfessorMapper;
import com.example.data.repository.ProfessorRepository;
import com.example.data.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

}
