package com.example.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentEntity extends BaseEntity<Long> {

    private String code;

    private String name;

    private Boolean active;

    // OneToMany
    @OneToMany(mappedBy = "department")
    private List<StudentEntity> students = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<ProfessorEntity> professors = new ArrayList<>();
}