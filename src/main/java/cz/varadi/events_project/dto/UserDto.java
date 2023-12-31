package cz.varadi.events_project.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Getter
@Setter
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

    private boolean isActive;

    private String[] requestedRoles;

    public boolean hasRoleById(long id) {
        return roles.stream().anyMatch(role -> role.getId() == id);
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean getIsActive(){
        return isActive;
    }
}
