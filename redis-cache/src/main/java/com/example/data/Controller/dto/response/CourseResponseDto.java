package com.example.data.Controller.dto.response;

import com.example.data.Controller.dto.EnrollmentDto;
import com.example.data.Controller.dto.ProfessorDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private String courseCode;
    private String title;
    private Integer units;
    private Boolean active;
    private ProfessorDto professor;
    private List<EnrollmentDto> enrollments;
}
