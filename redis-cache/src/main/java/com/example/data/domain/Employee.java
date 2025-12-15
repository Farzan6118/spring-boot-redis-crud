package com.example.data.domain;

import com.example.data.domain.constant.GenderType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee extends BaseEntity<Long> {
    private String firstname;
    private String lastname;
    private String nationalCode;
    private LocalDate birthDate;
    private String phoneNumber;
    private GenderType gender;
    private String address;
    private String email;
    private String role;
    private String position;
    private Integer departmentId;
    private LocalDateTime hiringDate;

}
