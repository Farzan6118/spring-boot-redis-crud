package com.example.data.domain.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public enum RecordStatus {

    INACTIVE(0, "status.type.inactive.not.deleted"),
    ACTIVE(1, "status.type.active.not.deleted");

    private final Integer id;
    private final String title;

    public static Optional<RecordStatus> fromValue(int value) {
        for (RecordStatus statusType : RecordStatus.values()) {
            if (statusType.getId() == value) {
                return Optional.of(statusType);
            }
        }
        return Optional.empty();
    }

}
