package com.example.data.repository.impl;


import com.samimHealth.business.domain.entity.BaseEntity;
import com.samimHealth.business.repository.BaseEntityRepository;
import com.samimHealth.business.repository.jpa.BaseEntityJpa;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseEntityRepositoryImpl<U extends BaseEntityJpa<T, ID>,
        T extends BaseEntity<ID>, ID extends Serializable> implements BaseEntityRepository<T, ID> {

    protected final U jpaRepository;

    public BaseEntityRepositoryImpl(U jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Boolean existsById(ID id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void saveAll(List<T> entities) {
        jpaRepository.saveAll(entities);
    }
}
