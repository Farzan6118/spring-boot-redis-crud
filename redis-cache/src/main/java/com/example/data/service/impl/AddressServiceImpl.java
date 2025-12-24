package com.example.data.service.impl;

import com.example.data.Controller.dto.request.AddressRequestDto;
import com.example.data.Controller.dto.response.AddressResponseDto;
import com.example.data.domain.AddressEntity;
import com.example.data.mapper.AddressMapper;
import com.example.data.repository.AddressRepository;
import com.example.data.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    @Transactional
    public AddressResponseDto create(AddressRequestDto requestDto) {
        AddressEntity entity = mapper.toEntity(requestDto);

        if (Boolean.TRUE.equals(requestDto.getPrimaryAddress())) {
            repository.removeAllPrimary();
        }

        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional
    public AddressResponseDto getById(Long id) {
        AddressEntity entity = repository.findByIdAndDeletedIs(id, false)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Address not found"));

        return mapper.toResponse(entity);
    }

    @Override
    @Transactional
    public List<AddressResponseDto> getAll() {
        return repository.findAllByDeletedIs(false)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        AddressEntity entity = repository.findByIdAndDeletedIs(id, false)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Address not found"));

        entity.setDeleted(true);
    }

    @Override
    @Transactional
    public AddressResponseDto update(AddressRequestDto requestDto, Long id) {
        AddressEntity entity = repository.findByIdAndDeletedIs(id, false)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Address not found"));

        Optional.ofNullable(requestDto.getCity()).ifPresent(entity::setCity);
        Optional.ofNullable(requestDto.getStreet()).ifPresent(entity::setStreet);
        Optional.ofNullable(requestDto.getPostalCode()).ifPresent(entity::setPostalCode);

        if (requestDto.getPrimaryAddress() != null) {
            if (requestDto.getPrimaryAddress()) {
                repository.removeAllPrimary();
                entity.setPrimaryAddress(true);
            } else {
                entity.setPrimaryAddress(false);
            }
        }

        return mapper.toResponse(repository.save(entity));
    }

    @Transactional
    @Override
    public Long countActive() {
        return repository.countByDeletedIs(false);
    }
}
