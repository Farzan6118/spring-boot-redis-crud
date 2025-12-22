package com.example.data.service.impl;

import com.example.data.mapper.StudentMapper;
import com.example.data.repository.StudentRepository;
import com.example.data.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

}
