package com.example.data.service.impl;

import com.example.data.Controller.dto.request.CourseRequestDto;
import com.example.data.Controller.dto.response.CourseResponseDto;
import com.example.data.domain.CourseEntity;
import com.example.data.mapper.CourseMapper;
import com.example.data.repository.CourseRepository;
import com.example.data.service.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;

    @Override
    @Transactional
    public CourseResponseDto create(CourseRequestDto requestDto) {
        CourseEntity entity = mapper.toEntity(requestDto);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional
    public CourseResponseDto getById(Long id) {
        CourseEntity entity = repository.findByIdAndDeletedIs(id, false)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional
    public List<CourseResponseDto> getAll() {
        return repository.findAllByDeletedIs(false)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public CourseResponseDto update(Long id, CourseRequestDto requestDto) {
        CourseEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));

        Optional.ofNullable(requestDto.getCourseCode()).ifPresent(entity::setCourseCode);
        Optional.ofNullable(requestDto.getTitle()).ifPresent(entity::setTitle);
        Optional.ofNullable(requestDto.getUnits()).ifPresent(entity::setUnits);
        Optional.ofNullable(requestDto.getActive()).ifPresent(entity::setActive);

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        CourseEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        entity.setDeleted(true);
    }

    @Override
    @Transactional
    public Long countActive() {
        return repository.countByDeletedIs(false);
    }
}
