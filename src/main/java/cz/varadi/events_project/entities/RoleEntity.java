package cz.varadi.events_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "roles")
@Setter
@Getter
@NoArgsConstructor

public class RoleEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long id;

    @Column(name = "name", unique = true, nullable = false)
    public String name;

    public RoleEntity(String name) {
        this.name = name;
    }
}
