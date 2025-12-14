package com.example.data.Controller.dto.response;

import com.example.data.domain.constant.GenderType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EmployeeResponseDto(
        String id,
        String firstname,
        String lastname,
        String phoneNumber,
        String nationalCode,
        LocalDate birthDate,
        GenderType gender,
        String role,
        String email,
        String address,
        String position,
        String department,
        LocalDateTime hiringDate,
        LocalDateTime lastModifiedDate

        ) {
}
