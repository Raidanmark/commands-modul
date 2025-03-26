package org.example.model.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "chat_session")
public class ChatSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;

    String source, chatId;

    @Column(nullable = false)
    String status = "INACTIVE";

}
