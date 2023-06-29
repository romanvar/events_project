package cz.varadi.events_project.repositories;

import cz.varadi.events_project.entities.EventEntity;
import cz.varadi.events_project.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    public List<EventEntity> findAllByOwner(UserEntity userEntity);
}
