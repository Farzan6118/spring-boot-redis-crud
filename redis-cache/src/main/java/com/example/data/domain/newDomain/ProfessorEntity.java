//package com.example.data.domain.newDomain;
//
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GenerationType;
//
//@Entity
//@Table(name = "professors")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class ProfessorEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String employeeCode;
//
//    private String firstName;
//    private String lastName;
//
//    private Double salary;
//
//    private Boolean tenured;
//
//    private LocalDateTime hiredAt;
//
//    // ManyToOne
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id")
//    private DepartmentEntity department;
//
//    // OneToMany
//    @OneToMany(mappedBy = "professor")
//    private List<CourseEntity> courses = new ArrayList<>();
//}