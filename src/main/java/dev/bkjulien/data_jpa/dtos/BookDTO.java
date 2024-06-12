package dev.bkjulien.data_jpa.dtos;

import java.util.Set;
import java.util.UUID;

public record BookDTO(
        String title,
        UUID publisherId,
        Set<UUID> authorIds,
        String reviewComment
) {
}
