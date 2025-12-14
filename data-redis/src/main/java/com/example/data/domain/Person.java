package com.example.data.domain;

import com.example.data.domain.constant.GenderType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@RedisHash("Person")
public class Person implements RedisIdentifiable, Serializable {

    private String id;
    private String firstname;
    private String lastname;
    private String nationalCode;
    private LocalDate birthDate;
    private String phoneNumber;
    private GenderType gender;
    private String address;
    private String email;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;


}
