package cz.varadi.events_project.repositories;

import cz.varadi.events_project.entities.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<EventsEntity, Long> {
}
