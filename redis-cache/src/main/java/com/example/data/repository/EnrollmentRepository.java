package com.example.data.repository;

import com.example.data.domain.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {

    <ID extends Serializable> Optional<EnrollmentEntity> findByIdAndDeletedIs(ID id, boolean deleted);

    Optional<EnrollmentEntity> findAllByDeletedIs(boolean deleted);

    Long countByDeletedIs(boolean deleted);
}