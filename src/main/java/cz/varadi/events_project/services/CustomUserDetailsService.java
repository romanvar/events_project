package cz.varadi.events_project.services;

import cz.varadi.events_project.entities.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;

    @Autowired
    public CustomUserDetailsService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try {
            var user = userService.findByEmail(email);
            System.out.println("Found user: " + user.getEmail());
            return buildUserForAuthentication(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new UsernameNotFoundException(e.getMessage());
        }

    }

    private UserDetails buildUserForAuthentication(UserEntity user) {
        String[] roles = user.getRoles().stream()
                .map(it -> it.name.toUpperCase())
                .toArray(String[]::new);
        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(roles)

                .build();
    }

}