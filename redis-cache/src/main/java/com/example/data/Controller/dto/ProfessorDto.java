package com.example.data.Controller.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDto {

    private Long id;
    private LocalDateTime CreatedDate;
    private LocalDateTime modifiedDate;

    private String employeeCode;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String email;
    private BigDecimal salary;
    private Boolean tenured;
    private LocalDateTime hiringDateTime;
    private DepartmentDto department;
    private List<CourseDto> courses;
}
