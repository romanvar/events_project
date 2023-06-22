package cz.varadi.events_project.services;


import cz.varadi.events_project.dto.UserDto;
import cz.varadi.events_project.entities.RoleEntity;
import cz.varadi.events_project.entities.UserEntity;
import cz.varadi.events_project.repositories.RoleRepository;
import cz.varadi.events_project.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    @Override
    public UserEntity registerNewUserAccount(UserDto userDto) {
        UserEntity user = new UserEntity(userDto.getName(),
                userDto.getSurname(),userDto.getEmail(),
                userDto.getPassword());
        RoleEntity userRole = roleRepository.findByName("user");
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        return userRepository.save(user);
    }
}
