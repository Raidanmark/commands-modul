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
@Table(name = "status")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;

    @Column(unique = true)
    String name;

    @ManyToMany
    @JoinTable(
            name = "status_transitions",
            joinColumns = @JoinColumn(name = "from_status_id"),
            inverseJoinColumns = @JoinColumn(name = "to_status_id")
    )
    private Set<StatusEntity> allowedTransition = new HashSet<>();

}
