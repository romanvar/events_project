package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.RoleDto;
import cz.varadi.events_project.dto.UserDto;
import cz.varadi.events_project.entities.RoleEntity;
import cz.varadi.events_project.entities.UserEntity;
import cz.varadi.events_project.exceptions.UserNotFoundException;
import cz.varadi.events_project.repositories.RoleRepository;
import cz.varadi.events_project.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AdminServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserDto> getUserList() {
        return userRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> RoleDto.builder()
                        .id(role.id)
                        .name(role.name)
                        .build())
                .collect(Collectors.toList());
    }

    private UserDto mapToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .email(userEntity.getEmail())
                .roles(userEntity.getRoles().stream().map(
                        role -> RoleDto.builder()
                                .id(role.id)
                                .name(role.name)
                                .build()
                ).collect(Collectors.toSet()))
                .build();

    }

    @Override
    public UserDto getUser(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapToDto(user);
    }

    @Override
    public UserEntity changeUserAccount(UserDto userDto) {
        UserEntity user = userRepository.findById(userDto.getId()).orElseThrow(() -> new UserNotFoundException("User not found");
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setSurname(userDto.getSurname());

        RoleEntity userRole;
        Set<RoleEntity> rolesTmp = new HashSet<>();


        for (int i = 0; i < userDto.getRequestedRoles().length; i++) {
            int q = i + 1;
            Long count = (long) q;
            userRole = roleRepository.getReferenceById(count);
            rolesTmp.add(userRole);

        }
        user.setRoles(rolesTmp);

        userRepository.save(user);
        return user;
    }
}
