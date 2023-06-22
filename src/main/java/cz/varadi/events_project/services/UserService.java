package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.UserDto;
import cz.varadi.events_project.entities.UserEntity;

public interface UserService {
    UserEntity registerNewUserAccount(UserDto userDto);
}
