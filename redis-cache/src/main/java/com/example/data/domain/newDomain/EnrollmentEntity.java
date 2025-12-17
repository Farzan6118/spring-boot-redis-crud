//package com.example.data.domain.newDomain;
//
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GenerationType;
//
//@Entity
//@Table(name = "enrollments",
//        uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"}))
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class EnrollmentEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private LocalDateTime enrolledAt;
//
//    private Double grade;
//
//    private Boolean passed;
//
//    // ManyToOne
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id")
//    private StudentEntity student;
//
//    // ManyToOne
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "course_id")
//    private CourseEntity course;
//}