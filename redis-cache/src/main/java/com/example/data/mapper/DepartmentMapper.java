package com.example.data.mapper;

import com.example.data.Controller.dto.response.DepartmentResponseDto;
import com.example.data.domain.DepartmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentResponseDto toResponse(DepartmentEntity entity);
}