package com.example.data.repository;

import com.example.data.domain.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    <ID extends Serializable> Optional<CourseEntity> findByIdAndDeletedIs(ID id, boolean deleted);

    Optional<CourseEntity> findAllByDeletedIs(boolean deleted);

    Long countByDeletedIs(boolean deleted);

}