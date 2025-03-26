package org.example.services.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CommandDto {

    @NonNull
    Long id;

    @NonNull
    String name;

    @NonNull
    Set<Long> availableStatusIds;

}
