package com.example.data.service.impl;

import com.example.data.Controller.dto.request.EnrollmentRequestDto;
import com.example.data.Controller.dto.response.EnrollmentResponseDto;
import com.example.data.domain.EnrollmentEntity;
import com.example.data.mapper.EnrollmentMapper;
import com.example.data.repository.EnrollmentRepository;
import com.example.data.service.EnrollmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository repository;
    private final EnrollmentMapper mapper;

    @Transactional
    @Override
    public EnrollmentResponseDto create(EnrollmentRequestDto requestDto) {
        EnrollmentEntity entity = mapper.toEntity(requestDto);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Transactional
    @Override
    public EnrollmentResponseDto getById(Long id) {
        EnrollmentEntity entity = repository.findByIdAndDeletedIs(id, false)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        return mapper.toResponse(entity);
    }

    @Transactional
    @Override
    public List<EnrollmentResponseDto> getAll() {
        return repository.findAllByDeletedIs(false)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional
    @Override
    public EnrollmentResponseDto update(Long id, EnrollmentRequestDto requestDto) {
        EnrollmentEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));

        Optional.ofNullable(requestDto.getGrade()).ifPresent(entity::setGrade);
        Optional.ofNullable(requestDto.getPassed()).ifPresent(entity::setPassed);
        Optional.ofNullable(requestDto.getEnrolledAt()).ifPresent(entity::setEnrolledAt);

        return mapper.toResponse(repository.save(entity));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        EnrollmentEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        entity.setDeleted(true);
    }

    @Transactional
    @Override
    public Long countActive() {
        return repository.countByDeletedIs(false);
    }


}
