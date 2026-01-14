package com.expensetracker.expensetrackerapi.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.expensetrackerapi.user.User;
import com.expensetracker.expensetrackerapi.user.UserMapper;
import com.expensetracker.expensetrackerapi.user.UserDTO.AuthResponseDTO;
import com.expensetracker.expensetrackerapi.user.UserDTO.LoginRequestDTO;
import com.expensetracker.expensetrackerapi.user.UserDTO.RegisterDTO;
import com.expensetracker.expensetrackerapi.user.UserDTO.UserResponsDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.AuthenticationException;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    
    
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          UserService userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public UserResponsDTO signup(@RequestBody RegisterDTO registerDTO) {
        //TODO: process POST request
        User user= new User();
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        User savedUser = userService.saveUser(user);
        return UserMapper.toUserResponseDTO(savedUser);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        try {
            String email=loginRequestDTO.getEmail();
            String password=loginRequestDTO.getPassword();
            Authentication auth=authenticationManager.authenticate(
                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(email, password)
            );
            System.out.println("Authentication successful: " + auth.isAuthenticated());
            System.out.println("Authenticated user: " + auth.getName());
            if (!auth.getName().equals(loginRequestDTO.getEmail())) {
                throw new RuntimeException("Invalid credentials");
            }
            String token = jwtUtil.generateToken(loginRequestDTO.getEmail());
            return UserMapper.toAuthResponseDTO(
                token,
                UserMapper.toUserResponseDTO(
                    userService.getUserEntityByEmail(loginRequestDTO.getEmail())
                )
            );
        } catch (AuthenticationException ex) {
            // TODO: handle exception
            throw new RuntimeException("Invalid username or password");
        }
    }
    
}
