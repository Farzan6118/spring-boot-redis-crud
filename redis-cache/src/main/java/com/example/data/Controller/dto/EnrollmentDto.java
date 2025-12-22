package com.example.data.Controller.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDto {

    private Long id;
    private LocalDateTime CreatedDate;
    private LocalDateTime modifiedDate;

    private Double grade;
    private Boolean passed;
    private StudentDto student;
    private CourseDto course;
    private LocalDateTime enrollmentDateTime;
}
