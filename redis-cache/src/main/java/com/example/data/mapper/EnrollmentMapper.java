package com.example.data.mapper;

import com.example.data.Controller.dto.request.EnrollmentRequestDto;
import com.example.data.Controller.dto.response.EnrollmentResponseDto;
import com.example.data.domain.EnrollmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    EnrollmentResponseDto toResponse(EnrollmentEntity entity);

    EnrollmentEntity toEntity(EnrollmentRequestDto dto);
}