package com.example.data.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AuditorAwareConfig implements AuditorAware<UUID> {

    @Value("${system.default.staffId}")
    private UUID systemDefaultStaffId;

    @Override
    public @NotNull Optional<UUID> getCurrentAuditor() {
        return extractUserUuid().or(() -> Optional.of(systemDefaultStaffId));
    }

    private Optional<UUID> extractUserUuid() {
        return Optional.of(UUID.randomUUID());
    }
}
