package com.example.data.Controller.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {

    private String city;
    private String street;
    private String postalCode;
    private Boolean primaryAddress;
}
