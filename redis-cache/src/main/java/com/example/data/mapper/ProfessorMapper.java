package com.example.data.mapper;

import com.example.data.Controller.dto.response.ProfessorResponseDto;
import com.example.data.domain.ProfessorEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = DepartmentMapper.class
)
public interface ProfessorMapper {

    ProfessorResponseDto toResponse(ProfessorEntity entity);
}