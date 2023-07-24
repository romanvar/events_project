package cz.varadi.events_project.services;

import cz.varadi.events_project.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
            boolean active = user.isActive();

            if (user.isActive() == true) {
                return buildUserForAuthentication(user);
            } else {
                throw new UsernameNotFoundException("User is not Activated");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
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