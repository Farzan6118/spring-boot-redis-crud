package com.example.data.repository;

import com.example.data.domain.AddressEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    <ID extends Serializable> Optional<AddressEntity> findByIdAndDeletedIs(ID id, boolean deleted);

    List<AddressEntity> findAllByDeletedIs(boolean deleted);

    Long countByDeletedIs(boolean deleted);

    @Modifying
    @Transactional
    @Query("update AddressEntity a set a.primaryAddress = false")
    void removeAllPrimary();

}