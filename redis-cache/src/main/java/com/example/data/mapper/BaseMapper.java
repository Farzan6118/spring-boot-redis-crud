package com.example.data.mapper;

import java.io.Serializable;

public interface BaseMapper<E, REQ, RES> extends Serializable {
    RES toDto(E entity);

    E toEntity(REQ request);
}
