package com.example.data.Controller.dto.response;

import com.example.data.domain.constant.GenderType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PersonResponseDto(
        String id,
        String firstname,
        String lastname,
        String nationalCode,
        LocalDate birthDate,
        String phoneNumber,
        GenderType gender,
        String address,
        String email,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate
) {
}
