package cz.varadi.events_project.repositories;

import cz.varadi.events_project.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
