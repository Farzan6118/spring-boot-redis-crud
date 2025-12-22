package com.example.data.Controller.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRequestDto {

    private String employeeCode;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String email;
    private BigDecimal salary;
    private Boolean tenured;
    private LocalDateTime hiringDateTime;


}
