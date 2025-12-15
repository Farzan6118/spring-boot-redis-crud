package com.example.data.mapper;

import com.example.data.Controller.dto.request.EmployeeRequestDto;
import com.example.data.Controller.dto.response.EmployeeResponseDto;
import com.example.data.domain.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeResponseDto toDto(Employee employee);

    Employee toEntity(EmployeeRequestDto requestDto);
}