package cz.varadi.events_project.dto;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAdministrationDto {

    private long id;
    private String name;
    private String surname;
    private String email;
}
