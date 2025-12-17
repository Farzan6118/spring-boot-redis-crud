//package com.example.data.domain.newDomain;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GenerationType;
//
//@Entity
//@Table(name = "students")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class StudentEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String studentNumber;
//
//    private String firstName;
//    private String lastName;
//
//    private Integer age;
//
//    private Boolean active;
//
//    private LocalDateTime registeredAt;
//
//    // OneToOne
//    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private AddressEntity address;
//
//    // ManyToOne
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id")
//    private DepartmentEntity department;
//
//    // OneToMany
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    private List<EnrollmentEntity> enrollments = new ArrayList<>();
//}