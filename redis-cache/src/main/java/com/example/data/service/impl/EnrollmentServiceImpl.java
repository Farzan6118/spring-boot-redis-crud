package com.example.data.service.impl;

import com.example.data.mapper.EnrollmentMapper;
import com.example.data.repository.EnrollmentRepository;
import com.example.data.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository repository;
    private final EnrollmentMapper mapper;

}
