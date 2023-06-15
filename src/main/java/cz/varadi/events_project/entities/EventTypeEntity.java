package cz.varadi.events_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "event_type")
@Getter
@Setter
@NoArgsConstructor
public class EventTypeEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public EventTypeEntity(String name) {
        this.name = name;
    }
}
