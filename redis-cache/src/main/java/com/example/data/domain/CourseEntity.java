package com.example.data.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseEntity extends BaseEntity<Long> {

    private String courseCode;

    private String title;

    private Integer units;

    private Boolean active;

    // ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    private ProfessorEntity professor;

    // OneToMany
    @OneToMany(mappedBy = "course")
    private List<EnrollmentEntity> enrollments = new ArrayList<>();
}