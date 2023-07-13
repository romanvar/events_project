package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.RoleDto;
import cz.varadi.events_project.dto.UserDto;
import cz.varadi.events_project.entities.UserEntity;

import java.util.List;

public interface AdminService {
    public List<UserDto> getUserList();

    List<RoleDto> getAllRoles();

    UserDto getUser(Long id);

    UserEntity changeUserAccount(UserDto userDto);
}
