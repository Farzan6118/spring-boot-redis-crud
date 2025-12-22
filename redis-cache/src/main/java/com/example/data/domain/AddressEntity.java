package com.example.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity extends BaseEntity<Long> {

    private String city;

    private String street;

    private String postalCode;

    private Boolean primaryAddress;

    // OneToOne (Owner)
    @OneToOne(fetch = FetchType.LAZY)
    private StudentEntity student;
}