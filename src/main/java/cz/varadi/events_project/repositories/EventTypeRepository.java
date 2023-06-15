package cz.varadi.events_project.repositories;

import cz.varadi.events_project.entities.EventTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends JpaRepository<EventTypeEntity, Long> {
}
