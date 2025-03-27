package org.example.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.entities.StatusEntity;
import org.example.model.repositories.StatusRepository;
import org.example.services.dto.StatusDto;
import org.example.services.factories.StatusDtoFactory;
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
public class StatusController {

    StatusRepository statusRepository;
    StatusDtoFactory statusDtoFactory;

    public static final String CREATE_STATUS = "/api/statuses";

    @PostMapping(CREATE_STATUS)
    public StatusDto create(@RequestParam String name) {

        StatusEntity status = statusRepository.saveAndFlush(
                StatusEntity.builder()
                .name(name)
                .allowedTransition(new HashSet<>())
                .build()
        );

        return statusDtoFactory.createStatusDto(status);
    }
}
