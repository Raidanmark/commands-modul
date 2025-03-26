package org.example.services.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatSessionDto {
    @NonNull
    Long id;

    @NonNull
    String source;

    @NonNull
    String chatId;

    @NonNull
    String status;
}
