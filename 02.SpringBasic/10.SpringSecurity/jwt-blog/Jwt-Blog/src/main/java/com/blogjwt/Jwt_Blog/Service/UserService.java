package com.blogjwt.Jwt_Blog.Service;

import com.blogjwt.Jwt_Blog.Entity.User;
import com.blogjwt.Jwt_Blog.Repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserEntity(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
