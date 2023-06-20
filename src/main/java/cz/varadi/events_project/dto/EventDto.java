package cz.varadi.events_project.dto;

import cz.varadi.events_project.entities.EventTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private LocalDate eventDate;
    private String eventName;
    private String description;
    private EventTypeEntity eventTypeEntity;
    private String label;


}
