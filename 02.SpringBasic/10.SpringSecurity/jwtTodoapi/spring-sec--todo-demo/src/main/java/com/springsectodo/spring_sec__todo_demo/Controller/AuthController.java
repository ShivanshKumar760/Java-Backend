package com.springsectodo.spring_sec__todo_demo.Controller;

import com.springsectodo.spring_sec__todo_demo.Config.JwtUtil;
import com.springsectodo.spring_sec__todo_demo.DTO.LoginRequestDTO;
import com.springsectodo.spring_sec__todo_demo.DTO.LoginResponseDTO;
import com.springsectodo.spring_sec__todo_demo.DTO.SignupRequestDTO;
import com.springsectodo.spring_sec__todo_demo.Mapper.AuthMapper;
import com.springsectodo.spring_sec__todo_demo.Service.UserService;
import com.springsectodo.spring_sec__todo_demo.UserEntity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
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
    public String signup(@RequestBody SignupRequestDTO request) {
        if (userService.userExists(request.getUsername())) {
            return "Username already exists";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        User catchCreatedUser=userService.saveUser(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {
        try {
            String username= AuthMapper.toUsername(request);
            String pass=AuthMapper.toPassword(request);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, pass)
            );
            String token = jwtUtil.generateToken(request.getUsername());
//            return new LoginResponseDTO(token);
            return AuthMapper.toReponse(token);
        } catch (AuthenticationException ex) {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
