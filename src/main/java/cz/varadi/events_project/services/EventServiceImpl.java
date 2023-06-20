package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.EventDto;
import cz.varadi.events_project.entities.EventEntity;
import cz.varadi.events_project.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public EventDto mapToDto(EventEntity eventEntity) {
        return EventDto
                .builder()
                .eventDate(eventEntity.getEventDate())
                .eventName(eventEntity.getEventName())
                .description(eventEntity.getEventDescription())
                .eventTypeEntity(eventEntity.getEventTypeEntity())
                .label(eventEntity.getEventLabel())
                .build();


    }
}
