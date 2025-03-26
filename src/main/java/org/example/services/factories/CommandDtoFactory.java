package org.example.services.factories;

import org.example.model.entities.CommandEntity;
import org.example.model.entities.StatusEntity;
import org.example.services.dto.CommandDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CommandDtoFactory {
    public CommandDto createCommandDto(CommandEntity entity) {
        return CommandDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .availableStatusIds(entity
                        .getAvailableStatuses()
                        .stream()
                        .map(StatusEntity::getId)
                        .collect(Collectors
                                .toSet()))
                .build();
    }
}
