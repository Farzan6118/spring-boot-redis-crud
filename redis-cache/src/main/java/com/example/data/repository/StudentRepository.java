package com.example.data.repository;

import com.example.data.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    <ID extends Serializable> Optional<StudentEntity> findByIdAndDeletedIs(ID id, boolean deleted);

    Optional<StudentEntity> findAllByDeletedIs(boolean deleted);

    Long countByDeletedIs(boolean deleted);
}