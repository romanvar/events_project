package cz.varadi.events_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class EventsEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;


    @ManyToOne()
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    @Column(name = "create_date")
    private LocalDate createdAt;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "event_type_id", nullable = false)
    private EventTypeEntity eventTypeEntity;


    @Column(name = "label", nullable = true)
    private String label;


    public EventsEntity(UserEntity owner, LocalDate createdAt, LocalDate eventDate, String eventName, String description, EventTypeEntity eventTypeEntity, String label) {
        this.owner = owner;
        this.createdAt = LocalDate.now();
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.description = description;
        this.eventTypeEntity = eventTypeEntity;
        this.label = label;
    }
}
