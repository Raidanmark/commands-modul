package org.example.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.entities.CommandEntity;
import org.example.model.entities.StatusEntity;
import org.example.model.repositories.CommandRepository;
import org.example.model.repositories.StatusRepository;
import org.example.services.dto.CommandDto;
import org.example.services.factories.CommandDtoFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional

@RestController
public class CommandController {
    CommandRepository commandRepository;

    CommandDtoFactory commandDtoFactory;

    StatusRepository statusRepository;

    public static final String CREATE_COMMAND = "/api/commands";


    @PostMapping(CREATE_COMMAND)
    public CommandDto createCommand(@RequestParam String name,  Set<Long> availableStatusIds) {

        Set<StatusEntity> availableStatuses = new HashSet<>(statusRepository.findAllById(availableStatusIds));

        CommandEntity command = commandRepository.saveAndFlush(
                CommandEntity.builder()
                        .name(name)
                        .availableStatuses(availableStatuses)
                        .build()
        );

        return  commandDtoFactory.createCommandDto(command);

    }

}
