package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.EventDto;
import cz.varadi.events_project.entities.EventEntity;
import cz.varadi.events_project.entities.UserEntity;
import cz.varadi.events_project.repositories.EventRepository;
import cz.varadi.events_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public DashboardServiceImpl(EventRepository eventRepository, UserRepository userRepository) {

        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<EventDto> getMyEvents(String username) {
        UserEntity user = userRepository.findByEmail(username);
        return eventRepository
                .findAllByOwner(user)
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
