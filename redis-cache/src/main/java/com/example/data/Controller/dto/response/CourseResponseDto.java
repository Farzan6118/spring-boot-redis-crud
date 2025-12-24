package com.example.data.Controller.dto.response;

import lombok.*;

import java.time.LocalDateTime;

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
}
