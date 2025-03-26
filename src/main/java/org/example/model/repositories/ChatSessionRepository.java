package org.example.model.repositories;

import org.example.model.entities.ChatSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSessionEntity, Long> {

}
