package com.example.data.service.impl;

import com.example.data.Controller.dto.request.EmployeeRequestDto;
import com.example.data.Controller.dto.response.EmployeeResponseDto;
import com.example.data.domain.Employee;
import com.example.data.mapper.EmployeeMapper;
import com.example.data.repository.EmployeeRepository;
import com.example.data.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper employeeMapper;

    @Override
    @CacheEvict(value = {"EmployeeResponseDto"}, allEntries = true)
    public EmployeeResponseDto create(EmployeeRequestDto requestDto) {
        Employee employeeEntity = employeeMapper.toEntity(requestDto);
        Employee savedEmployee = repository.save(employeeEntity);
        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    @CacheEvict(value = {"EmployeeResponseDto"}, allEntries = true)
    public EmployeeResponseDto update(EmployeeRequestDto requestDto, Long id) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee does not exist"));

        existingEmployee.setFirstname(requestDto.getFirstname());
        existingEmployee.setLastname(requestDto.getLastname());
        existingEmployee.setNationalCode(requestDto.getNationalCode());
        existingEmployee.setBirthDate(requestDto.getBirthDate());
        existingEmployee.setPhoneNumber(requestDto.getPhoneNumber());
        existingEmployee.setGender(requestDto.getGender());
        existingEmployee.setAddress(requestDto.getAddress());
        existingEmployee.setEmail(requestDto.getEmail());
        existingEmployee.setRole(requestDto.getRole());
        existingEmployee.setPosition(requestDto.getPosition());
        existingEmployee.setDepartmentId(requestDto.getDepartmentId());
        existingEmployee.setHiringDate(requestDto.getHiringDate());

        Employee updatedEmployee = repository.save(existingEmployee);

        return employeeMapper.toDto(updatedEmployee);
    }

    @Override
    public Optional<EmployeeResponseDto> findById(Long id) {
        return repository.findById(id).map(employeeMapper::toDto);
    }

    @Cacheable(
            value = "EmployeeResponseDto",
            key = "#id",
            unless = "#result == null"
    )
    @Override
    public EmployeeResponseDto getById(Long id) {
        Employee employeeEntity = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee does not exist"));
        return employeeMapper.toDto(employeeEntity);
    }

    @Override
    public List<EmployeeResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    @Override
    @CacheEvict(value = {"EmployeeResponseDto"}, allEntries = true)
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Cacheable(
            value = "getEmployeeByDepartmentId",
            key = "#departmentId",
            unless = "#result == null"
    )
    @Override
    public List<EmployeeResponseDto> getEmployeesByDepartmentId(Integer departmentId) {
        return repository.findByDepartmentId(departmentId).stream().map(employeeMapper::toDto).toList();
    }
}
