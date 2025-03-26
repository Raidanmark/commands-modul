package org.example.model.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "command")
public class CommandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;

    @Column(unique = true)
    String name;

    @ManyToMany
    @JoinTable(
            name = "command_available_statuses",
            joinColumns = @JoinColumn(name = "command_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id")
    )
    private Set<StatusEntity> availableStatuses = new HashSet<>();

}
