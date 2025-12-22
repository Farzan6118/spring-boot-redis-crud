package com.example.data.Controller.dto.response;

import com.example.data.Controller.dto.StudentDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDto {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private String city;
    private String street;
    private String postalCode;
    private Boolean primaryAddress;
    private StudentDto student;
}
