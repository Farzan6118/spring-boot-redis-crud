package com.example.data.service.impl;

import com.example.data.mapper.CourseMapper;
import com.example.data.repository.CourseRepository;
import com.example.data.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;

}
