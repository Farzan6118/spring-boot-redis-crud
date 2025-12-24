package com.example.data.Controller.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDto {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private String code;
    private String name;
    private Boolean active;
}
