package com.example.data.service.impl;

import com.example.data.Controller.dto.request.StudentRequestDto;
import com.example.data.Controller.dto.response.StudentResponseDto;
import com.example.data.domain.StudentEntity;
import com.example.data.mapper.StudentMapper;
import com.example.data.repository.StudentRepository;
import com.example.data.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Transactional
    @Override
    public StudentResponseDto create(StudentRequestDto requestDto) {
        StudentEntity entity = mapper.toEntity(requestDto);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Transactional
    @Override
    public StudentResponseDto getById(Long id) {
        StudentEntity entity = repository.findByIdAndDeletedIs(id, false)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        return mapper.toResponse(entity);
    }

    @Transactional
    @Override
    public List<StudentResponseDto> getAll() {
        return repository.findAllByDeletedIs(false)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional
    @Override
    public StudentResponseDto update(Long id, StudentRequestDto requestDto) {
        StudentEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));

        Optional.ofNullable(requestDto.getStudentNumber()).ifPresent(entity::setStudentNumber);
        Optional.ofNullable(requestDto.getFirstName()).ifPresent(entity::setFirstName);
        Optional.ofNullable(requestDto.getLastName()).ifPresent(entity::setLastName);
        Optional.ofNullable(requestDto.getBirthDate()).ifPresent(entity::setBirthDate);
        Optional.ofNullable(requestDto.getActive()).ifPresent(entity::setActive);
        Optional.ofNullable(requestDto.getNationalCode()).ifPresent(entity::setNationalCode);
        Optional.ofNullable(requestDto.getEmail()).ifPresent(entity::setEmail);
        Optional.ofNullable(requestDto.getRegistrationDateTime()).ifPresent(entity::setRegisteredAt);

        return mapper.toResponse(repository.save(entity));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        StudentEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found"));
        entity.setDeleted(true);
    }

    @Transactional
    @Override
    public Long countActive() {
        return repository.countByDeletedIs(false);
    }

}
