package com.example.data.service;

import com.example.data.Controller.dto.request.AddressRequestDto;
import com.example.data.Controller.dto.response.AddressResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AddressService {

    AddressResponseDto create(AddressRequestDto requestDto);

    AddressResponseDto getById(Long id);

    List<AddressResponseDto> getAll();

    @Transactional(rollbackOn = Exception.class)
    void deleteById(Long id);

    AddressResponseDto update(AddressRequestDto requestDto, Long id);

    @Transactional
    Long countActive();
}
