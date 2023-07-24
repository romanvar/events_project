package cz.varadi.events_project.services;


import cz.varadi.events_project.dto.UserRegisterDto;
import cz.varadi.events_project.entities.UserEntity;

public interface UserService {
    UserEntity registerNewUserAccount(UserRegisterDto userRegisterDto);

    UserEntity findByEmail(String email);
}
