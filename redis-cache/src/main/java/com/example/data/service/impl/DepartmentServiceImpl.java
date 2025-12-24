package com.example.data.service.impl;

import com.example.data.Controller.dto.request.DepartmentRequestDto;
import com.example.data.Controller.dto.response.DepartmentResponseDto;
import com.example.data.domain.DepartmentEntity;
import com.example.data.mapper.DepartmentMapper;
import com.example.data.repository.DepartmentRepository;
import com.example.data.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    @Override
    @Transactional
    public DepartmentResponseDto create(DepartmentRequestDto requestDto) {
        DepartmentEntity entity = mapper.toEntity(requestDto);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional
    public DepartmentResponseDto getById(Long id) {
        DepartmentEntity entity = repository.findByIdAndDeletedIs(id, false)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional
    public List<DepartmentResponseDto> getAll() {
        return repository.findAllByDeletedIs(false)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public DepartmentResponseDto update(Long id, DepartmentRequestDto requestDto) {
        DepartmentEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));

        Optional.ofNullable(requestDto.getCode()).ifPresent(entity::setCode);
        Optional.ofNullable(requestDto.getName()).ifPresent(entity::setName);
        Optional.ofNullable(requestDto.getActive()).ifPresent(entity::setActive);

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        DepartmentEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        entity.setDeleted(true);
    }

    @Override
    @Transactional
    public Long countActive() {
        return repository.countByDeletedIs(false);
    }

}
