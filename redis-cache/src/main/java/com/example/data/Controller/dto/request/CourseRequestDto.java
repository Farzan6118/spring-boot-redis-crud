package com.example.data.Controller.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDto {

    private String courseCode;
    private String title;
    private Integer units;
    private Boolean active;

}
