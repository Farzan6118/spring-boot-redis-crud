package com.example.data.Controller.dto.request;

import com.example.data.domain.constant.GenderType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EmployeeRequestDto {

    @Schema(defaultValue = "MALE", allowableValues = {"MALE", "FEMALE"})
    private GenderType gender;

    @Schema(example = "John")
    @NotBlank
    private String firstname;

    @Schema(example = "Doe")
    @NotBlank
    private String lastname;

    @Schema(example = "0024125678", maxLength = 10)
    @Size(max = 10, message = "invalid nationalCode")
    private String nationalCode;

    @Schema(example = "1990-01-01")
    private LocalDate birthDate;

    @Schema(example = "john.doe@example.com")
    @Email
    private String email;

    @Schema(example = "09123456789", maxLength = 12)
    @Size(max = 12, message = "invalid phoneNumber")
    private String phoneNumber;

    @Schema(example = "Tehran, Iran")
    private String address;

    @Schema(example = "ADMIN")
    private String role;

    @Schema(example = "Senior Java Developer")
    private String position;

    @Schema(example = "IT")
    private String department;

    @Schema(example = "2023-05-01T09:00:00")
    private LocalDateTime hiringDate;
}