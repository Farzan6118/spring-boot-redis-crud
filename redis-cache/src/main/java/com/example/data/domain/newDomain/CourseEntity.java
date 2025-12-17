//package com.example.data.domain.newDomain;
//
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GenerationType;
//
//@Entity
//@Table(name = "courses")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class CourseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String courseCode;
//
//    private String title;
//
//    private Integer units;
//
//    private Boolean active;
//
//    // ManyToOne
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "professor_id")
//    private ProfessorEntity professor;
//
//    // OneToMany
//    @OneToMany(mappedBy = "course")
//    private List<EnrollmentEntity> enrollments = new ArrayList<>();
//}