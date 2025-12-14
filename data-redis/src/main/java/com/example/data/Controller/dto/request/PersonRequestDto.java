package com.example.data.Controller.dto.request;

import com.example.data.domain.constant.GenderType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class PersonRequestDto {

    @Schema(defaultValue = "MALE", allowableValues = {"MALE", "FEMALE"})
    private GenderType gender;

    @Schema(defaultValue = "John")
    private String firstname;

    @Schema(defaultValue = "Doe")
    private String lastname;

    @Schema(defaultValue = "0024125678")
    @Length(max = 10, message = "invalid nationalCode")
    private String nationalCode;

    @Schema(description = "Birth date (yyyy-MM-dd)", example = "1990-01-01")
    private LocalDate birthDate;

    @Schema(defaultValue = "john.doe@example.com")
    @Email
    private String email;

    @Schema(defaultValue = "09123456789")
    @Length(max = 12, message = "invalid phoneNumber")
    private String phoneNumber;

    @Schema(defaultValue = "Tehran, Iran")
    private String address;
}