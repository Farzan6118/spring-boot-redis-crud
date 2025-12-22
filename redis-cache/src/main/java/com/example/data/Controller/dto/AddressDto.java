package com.example.data.Controller.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private LocalDateTime CreatedDate;
    private LocalDateTime modifiedDate;

    private String city;
    private String street;
    private String postalCode;
    private Boolean primaryAddress;
    private StudentDto student;
}
