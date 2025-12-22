package com.example.data.Controller.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestDto {

    private String code;
    private String name;
    private Boolean active;
}
