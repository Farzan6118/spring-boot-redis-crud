package com.example.data.mapper;

import com.example.data.Controller.dto.request.AddressRequestDto;
import com.example.data.Controller.dto.response.AddressResponseDto;
import com.example.data.domain.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<AddressEntity, AddressRequestDto, AddressResponseDto> {

    @Mapping(target = "modifiedDate", source = "modifiedDate")
    @Mapping(target = "createdDate", source = "createdDate")
    @Mapping(target = "id", source = "id")
    AddressResponseDto toResponse(AddressEntity entity);

    AddressEntity toEntity(AddressRequestDto dto);

}
