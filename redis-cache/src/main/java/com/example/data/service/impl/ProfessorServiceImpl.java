package com.example.data.service.impl;

import com.example.data.Controller.dto.request.ProfessorRequestDto;
import com.example.data.Controller.dto.response.ProfessorResponseDto;
import com.example.data.domain.ProfessorEntity;
import com.example.data.mapper.ProfessorMapper;
import com.example.data.repository.ProfessorRepository;
import com.example.data.service.ProfessorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    @Transactional
    @Override
    public ProfessorResponseDto create(ProfessorRequestDto requestDto) {
        ProfessorEntity entity = mapper.toEntity(requestDto);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Transactional
    @Override
    public ProfessorResponseDto getById(Long id) {
        ProfessorEntity entity = repository.findByIdAndDeletedIs(id, false)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        return mapper.toResponse(entity);
    }

    @Transactional
    @Override
    public List<ProfessorResponseDto> getAll() {
        return repository.findAllByDeletedIs(false)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional
    @Override
    public ProfessorResponseDto update(Long id, ProfessorRequestDto requestDto) {
        ProfessorEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));

        Optional.ofNullable(requestDto.getEmployeeCode()).ifPresent(entity::setEmployeeCode);
        Optional.ofNullable(requestDto.getFirstName()).ifPresent(entity::setFirstName);
        Optional.ofNullable(requestDto.getLastName()).ifPresent(entity::setLastName);
        Optional.ofNullable(requestDto.getEmail()).ifPresent(entity::setEmail);
        Optional.ofNullable(requestDto.getSalary()).ifPresent(entity::setSalary);
        Optional.ofNullable(requestDto.getTenured()).ifPresent(entity::setTenured);
        Optional.ofNullable(requestDto.getHiringDateTime()).ifPresent(entity::setHiringDate);

        return mapper.toResponse(repository.save(entity));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        ProfessorEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        entity.setDeleted(true);
    }

    @Transactional
    @Override
    public Long countActive() {
        return repository.countByDeletedIs(false);
    }

}
