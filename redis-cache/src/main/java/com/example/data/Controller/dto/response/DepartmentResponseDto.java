package com.example.data.Controller.dto.response;

import com.example.data.Controller.dto.ProfessorDto;
import com.example.data.Controller.dto.StudentDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDto {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private String code;
    private String name;
    private Boolean active;
    private List<StudentDto> students;
    private List<ProfessorDto> professors;
}
