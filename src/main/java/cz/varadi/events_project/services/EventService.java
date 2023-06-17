package cz.varadi.events_project.services;

import cz.varadi.events_project.entities.EventEntity;
import cz.varadi.events_project.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EventService {


    public List<EventEntity> getAllEvents();

}
