//package com.example.data.domain.newDomain;
//
//import jakarta.persistence.GenerationType;
//
//@Entity
//@Table(name = "departments")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class DepartmentEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String code;
//
//    private String name;
//
//    private Boolean active;
//
//    // OneToMany
//    @OneToMany(mappedBy = "department")
//    private List<StudentEntity> students = new ArrayList<>();
//
//    @OneToMany(mappedBy = "department")
//    private List<ProfessorEntity> professors = new ArrayList<>();
//}