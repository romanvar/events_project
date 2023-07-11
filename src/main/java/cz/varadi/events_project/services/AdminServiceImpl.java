package cz.varadi.events_project.services;

import cz.varadi.events_project.dto.UserAdministrationDto;
import cz.varadi.events_project.dto.UserChangeDto;
import cz.varadi.events_project.entities.UserEntity;
import cz.varadi.events_project.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserAdministrationDto> getUserList() {
        return userRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }

    private UserAdministrationDto mapToDto(UserEntity userEntity) {
        return UserAdministrationDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .email(userEntity.getEmail())
                .build();

    }

    @Override
    public UserAdministrationDto getUser(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapToDto(user);
    }

    @Override
    public UserEntity changeUserAccount(UserChangeDto userChangeDto) {
//        UserEntity user = userRepository.findById(userChangeDto.getId());

        return null;
    }
}
