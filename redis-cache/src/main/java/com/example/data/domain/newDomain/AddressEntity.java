//package com.example.data.domain.newDomain;
//
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GenerationType;
//
//@Entity
//@Table(name = "addresses")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class AddressEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String city;
//
//    private String street;
//
//    private String postalCode;
//
//    private Boolean primaryAddress;
//
//    // OneToOne (Owner)
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id")
//    private StudentEntity student;
//}