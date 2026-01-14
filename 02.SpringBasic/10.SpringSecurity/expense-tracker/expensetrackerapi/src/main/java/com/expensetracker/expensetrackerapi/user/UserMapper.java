package com.expensetracker.expensetrackerapi.user;

import com.expensetracker.expensetrackerapi.user.UserDTO.*;

public class UserMapper {
    //login request DTO to user
    public static User toUserViaLogin(LoginRequestDTO loginRequestDTO) {
        User user = new User();
        user.setEmail(loginRequestDTO.getEmail());
        user.setPassword(loginRequestDTO.getPassword());
        return user;
    }

    //register DTO to user
    public static User toUserViaRegister(RegisterDTO registerDTO) {
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        return user;
    }

    //user to user response DTO
    public static UserResponsDTO toUserResponseDTO(User user) {
        UserResponsDTO userResponsDTO = new UserResponsDTO();
        userResponsDTO.setId(user.getId());
        userResponsDTO.setEmail(user.getEmail());
        return userResponsDTO;
    }

    //toAuthReponseDTO
    public static AuthResponseDTO toAuthResponseDTO(String token, UserResponsDTO userResponsDTO) {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(token);
        authResponseDTO.setUser(userResponsDTO);
        return authResponseDTO;
    }


}
