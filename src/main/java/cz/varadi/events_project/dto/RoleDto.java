package cz.varadi.events_project.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class RoleDto {
    private long id;
    @EqualsAndHashCode.Exclude
    private String name;
}
