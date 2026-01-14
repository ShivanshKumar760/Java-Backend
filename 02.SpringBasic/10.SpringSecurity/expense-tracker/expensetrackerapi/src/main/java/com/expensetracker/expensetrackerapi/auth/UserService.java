package com.expensetracker.expensetrackerapi.auth;

import java.util.Collections;

import com.expensetracker.expensetrackerapi.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.expensetracker.expensetrackerapi.user.UserRepo;

import lombok.NonNull;

public class UserService implements UserDetailsService {
    
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }

    public boolean userExists(String username) {
        return userRepo.findByUsername(username).isPresent();
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User getUserEntityByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow();
    }

    public User getUserEntity(String username) {
        return userRepo.findByUsername(username).orElseThrow();
    }
    
}
