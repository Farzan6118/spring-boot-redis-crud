package com.example.data.repository;

import com.example.data.domain.AddressEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Modifying
    @Transactional
    @Query("update AddressEntity a set a.primaryAddress = false")
    void removeAllPrimary();

    Optional<AddressEntity> findByIdAndDeleted(Long id, boolean deleted);

    Optional<AddressEntity> findAllByDeletedIs(boolean deleted);

    Optional<AddressEntity> findByIdAndDeletedIs(Long id, boolean deleted);

    Long countByDeletedIs(boolean deleted);
}