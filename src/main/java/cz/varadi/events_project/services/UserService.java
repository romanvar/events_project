package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.UserLoginDto;
import cz.varadi.events_project.dto.UserRegisterDto;
import cz.varadi.events_project.entities.UserEntity;

public interface UserService {
    UserEntity registerNewUserAccount(UserRegisterDto userRegisterDto);

    boolean loginUser(UserLoginDto userLoginDto);
}
