package com.example.data.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorEntity extends BaseEntity<Long> {

    private String employeeCode;

    private String firstName;
    private String lastName;

    private Double salary;

    private Boolean tenured;

    private LocalDateTime hiringDate;

    private String nationalCode;
    private String email;
    // ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    private DepartmentEntity department;

    // OneToMany
    @OneToMany(mappedBy = "professor")
    private List<CourseEntity> courses = new ArrayList<>();
}