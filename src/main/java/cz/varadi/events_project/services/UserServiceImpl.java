package cz.varadi.events_project.services;


import cz.varadi.events_project.dto.UserLoginDto;
import cz.varadi.events_project.dto.UserRegisterDto;
import cz.varadi.events_project.entities.RoleEntity;
import cz.varadi.events_project.entities.UserEntity;
import cz.varadi.events_project.repositories.RoleRepository;
import cz.varadi.events_project.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    @Override
    public UserEntity registerNewUserAccount(UserRegisterDto userRegisterDto) {
        UserEntity user = new UserEntity(userRegisterDto.getName(),
                userRegisterDto.getSurname(), userRegisterDto.getEmail(),
                userRegisterDto.getPassword());
        RoleEntity userRole = roleRepository.findByName("user");
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public boolean loginUser(UserLoginDto userLoginDto) {

        var userDb = this.userRepository.findByEmail(userLoginDto.getEmail());

        return Objects.equals(userDb.getPassword(),userLoginDto.getPassword());
    }
}
