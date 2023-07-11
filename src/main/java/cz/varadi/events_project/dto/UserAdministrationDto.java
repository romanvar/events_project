package cz.varadi.events_project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAdministrationDto {

    private long id;
    private String name;
    private String surname;
    private String email;
}
