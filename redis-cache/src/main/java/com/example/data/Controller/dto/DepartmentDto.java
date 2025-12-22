package com.example.data.Controller.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    private LocalDateTime CreatedDate;
    private LocalDateTime modifiedDate;

    private String code;
    private String name;
    private Boolean active;
    private List<StudentDto> students;
    private List<ProfessorDto> professors;
}
