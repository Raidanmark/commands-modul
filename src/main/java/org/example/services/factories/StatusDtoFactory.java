package org.example.services.factories;

import org.example.model.entities.StatusEntity;
import org.example.services.dto.StatusDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StatusDtoFactory {
    public StatusDto createStatusDto(StatusEntity entity) {
        return StatusDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .allowedTransitionIds(entity
                        .getAllowedTransition()
                        .stream()
                        .map(StatusEntity::getId)
                        .collect(Collectors
                                .toSet()))
                .build();

    }
}
