package com.example.data.Controller.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequestDto {

    private Double grade;
    private Boolean passed;
    private LocalDateTime enrolledAt;

}
