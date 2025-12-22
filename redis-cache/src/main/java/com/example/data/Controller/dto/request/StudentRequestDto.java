package com.example.data.Controller.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {

    private String studentNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Boolean active;
    private String nationalCode;
    private String email;
    private LocalDateTime RegistrationDateTime;

}
