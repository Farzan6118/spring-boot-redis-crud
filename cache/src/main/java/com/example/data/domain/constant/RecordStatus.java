package com.example.data.domain.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public enum RecordStatus {

    INACTIVE_NOT_DELETED(1, "status.type.inactive.not.deleted"),
    ACTIVE_NOT_DELETED(2, "status.type.active.not.deleted"),
    INACTIVE_DELETED(3, "status.type.inactive.deleted"),
    ACTIVE_HIDE (4, "status.type.active.hide");

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
