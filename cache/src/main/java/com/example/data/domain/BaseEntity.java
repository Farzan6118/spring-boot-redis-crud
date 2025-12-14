package com.example.data.domain;


import com.example.data.domain.constant.RecordStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Nationalized;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseEntity<ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    private String enTitle;

    private String enDescription;

    @Nationalized
    private String faTitle;

    @Nationalized
    private String faDescription;

    @Nationalized
    private String arTitle;

    @Nationalized
    private String arDescription;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @CreatedBy
    @Column(nullable = false)
    private UUID createdByUserStaff;

    @LastModifiedBy
    private UUID modifiedByUserStaff;

    @Column(nullable = false)
    private RecordStatus recordStatus = RecordStatus.ACTIVE_NOT_DELETED;

}

