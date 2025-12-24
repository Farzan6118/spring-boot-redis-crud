package com.example.data.repository;

import com.example.data.domain.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    <ID extends Serializable> Optional<DepartmentEntity> findByIdAndDeletedIs(ID id, boolean deleted);

    Optional<DepartmentEntity> findAllByDeletedIs(boolean deleted);

    Long countByDeletedIs(boolean deleted);

}