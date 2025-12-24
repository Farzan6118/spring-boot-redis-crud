package com.example.data.repository;

import com.example.data.domain.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {

    <ID extends Serializable> Optional<ProfessorEntity> findByIdAndDeletedIs(ID id, boolean deleted);

    Optional<ProfessorEntity> findAllByDeletedIs(boolean deleted);

    Long countByDeletedIs(boolean deleted);
}