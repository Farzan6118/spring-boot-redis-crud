package com.example.data.Controller.dto.response;

import com.example.data.Controller.dto.AddressDto;
import com.example.data.Controller.dto.DepartmentDto;
import com.example.data.Controller.dto.EnrollmentDto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private String studentNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Boolean active;
    private String nationalCode;
    private String email;
    private AddressDto address;
    private DepartmentDto department;
    private List<EnrollmentDto> enrollments;
    private LocalDateTime RegistrationDateTime;
}
