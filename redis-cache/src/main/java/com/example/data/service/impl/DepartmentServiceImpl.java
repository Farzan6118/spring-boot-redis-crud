package com.example.data.service.impl;

import com.example.data.mapper.DepartmentMapper;
import com.example.data.repository.DepartmentRepository;
import com.example.data.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

}
