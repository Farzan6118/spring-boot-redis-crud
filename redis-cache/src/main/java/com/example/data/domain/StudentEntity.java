package com.example.data.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity extends BaseEntity<Long> {

    @Column(nullable = false)
    private String studentNumber;

    private String firstName;
    private String lastName;

    private String nationalCode;
    private String email;

    private LocalDate birthDate;
    private Boolean active;

    private LocalDateTime registeredAt;

    // OneToOne
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private AddressEntity address;

    // ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    private DepartmentEntity department;

    // OneToMany
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<EnrollmentEntity> enrollments = new ArrayList<>();
}