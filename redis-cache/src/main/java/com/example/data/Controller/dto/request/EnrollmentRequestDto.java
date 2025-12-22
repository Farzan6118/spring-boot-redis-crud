package com.example.data.Controller.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequestDto {

    private Double grade;
    private Boolean passed;

}
