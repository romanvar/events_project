package cz.varadi.events_project.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RoleDto {
    private long id;
    private String name;
}
