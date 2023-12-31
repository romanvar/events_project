package cz.varadi.events_project.repositories;

import cz.varadi.events_project.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

//    Optional<UserEntity> isActive(UserEntity user);


}
