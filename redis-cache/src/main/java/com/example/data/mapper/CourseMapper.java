package com.example.data.mapper;

import com.example.data.Controller.dto.request.CourseRequestDto;
import com.example.data.Controller.dto.response.CourseResponseDto;
import com.example.data.domain.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseResponseDto toResponse(CourseEntity entity);

    CourseEntity toEntity(CourseRequestDto dto);
}