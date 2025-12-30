package com.blogjwt.Jwt_Blog.Controller;

import com.blogjwt.Jwt_Blog.Config.JwtUtil;
import com.blogjwt.Jwt_Blog.DTO.LoginRequestDTO;
import com.blogjwt.Jwt_Blog.DTO.LoginResponseDTO;
import com.blogjwt.Jwt_Blog.DTO.SignUpDTO;
import com.blogjwt.Jwt_Blog.Entity.User;
import com.blogjwt.Jwt_Blog.Mapper.AuthMapper;
import com.blogjwt.Jwt_Blog.Service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
//    private final UserService userService;
//
//    public AuthController(UserService service){
//        this.userService=service;
//    }

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
    public String signup(@RequestBody SignUpDTO request){
        if (userService.userExists(request.getUsername())) {
            return "Username already exists";
        }
        User user = new User();
        user.setUsername(request.getUsername());

        user.setEmailId(request.getEmailId());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setPassword(request.getPassword());


        User catchCreatedUser=userService.saveUser(user);

        return "User registered successfully";
    }


    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {
        try {
            String username= AuthMapper.toUsername(request);
//            String userName=request.getUsername();
            String pass=AuthMapper.toPassword(request);
            Authentication auth= authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, pass)
            );

//            if(auth.getName().equals(request.getUsername())){
//
//                System.out.println(auth.getName());
//
//
//            }
            System.out.println(auth.getName());
            if (!auth.getName().equals(request.getUsername())) {
                throw new RuntimeException("Invalid credentials");
            }
            String token = jwtUtil.generateToken(request.getUsername());
//          return new LoginResponseDTO(token);
            return AuthMapper.toReponse(token);

        } catch (AuthenticationException ex) {
            throw new RuntimeException("Invalid username or password");
        }
    }

}
