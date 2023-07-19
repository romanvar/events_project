package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.RoleDto;
import cz.varadi.events_project.dto.UserDto;
import cz.varadi.events_project.entities.RoleEntity;
import cz.varadi.events_project.entities.UserEntity;
import cz.varadi.events_project.exceptions.UserNotFoundException;
import cz.varadi.events_project.repositories.RoleRepository;
import cz.varadi.events_project.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Stream<String> requestedRolesStream = userEntity.getRoles().stream().map(role -> "" + role.id);
        String[] requestedRoles = requestedRolesStream.toArray(size -> new String[size]);
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
                .requestedRoles(requestedRoles)
                .build();

    }

    @Override
    public UserDto getUser(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return mapToDto(user);
    }

    @Override
    public UserEntity changeUserAccount(UserDto userDto) {
        UserEntity user = userRepository.findById(userDto.getId()).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setSurname(userDto.getSurname());

        RoleEntity userRole;
        Set<RoleEntity> rolesTmp = new HashSet<>();


        for (String roleTmp : userDto.getRequestedRoles()) {
            Long idLong = Long.valueOf(roleTmp);
            userRole = roleRepository.getReferenceById(Long.valueOf(roleTmp));
            rolesTmp.add(userRole);


        }
        user.setRoles(rolesTmp);

        userRepository.save(user);
        return user;
    }
}
