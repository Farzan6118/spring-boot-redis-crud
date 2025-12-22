package com.example.data.Controller.dto.response;

import com.example.data.Controller.dto.CourseDto;
import com.example.data.Controller.dto.StudentDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponseDto {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private Double grade;
    private Boolean passed;
    private StudentDto student;
    private CourseDto course;
    private LocalDateTime enrollmentDateTime;
}
