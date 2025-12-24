package com.example.data.mapper;

import com.example.data.Controller.dto.request.StudentRequestDto;
import com.example.data.Controller.dto.response.StudentResponseDto;
import com.example.data.domain.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                AddressMapper.class,
                DepartmentMapper.class
        }
)
public interface StudentMapper {

    StudentResponseDto toResponse(StudentEntity entity);

    StudentEntity toEntity(StudentRequestDto dto);

}