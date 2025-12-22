package com.example.data.Controller.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Long id;
    private LocalDateTime CreatedDate;
    private LocalDateTime modifiedDate;

    private String courseCode;
    private String title;
    private Integer units;
    private Boolean active;
    private ProfessorDto professor;
    private List<EnrollmentDto> enrollments;
}