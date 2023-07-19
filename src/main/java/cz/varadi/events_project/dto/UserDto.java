package cz.varadi.events_project.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    @NotNull
    @NotEmpty
    private long id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String surname;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private Set<RoleDto> roles;

    private String[] requestedRoles;

    public boolean hasRoleById(long id) {
        return roles.stream().anyMatch(role -> role.getId() == id);
    }
}
