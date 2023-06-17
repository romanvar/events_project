package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.EventDto;
import cz.varadi.events_project.entities.EventEntity;
import cz.varadi.events_project.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventEntity> getAllEvents() {
        return eventRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public EventDto mapToDto(EventEntity eventEntity) {
//        return new EventDto(eventEntity.getEventDate(),
//                eventEntity.getEventName(),
//                eventEntity.setEventDate(),
//                eventEntity.getDescription(),
//                eventEntity.getEventTypeEntity(),
//                eventEntity.getLabel());

return new EventDto();
    }
}
