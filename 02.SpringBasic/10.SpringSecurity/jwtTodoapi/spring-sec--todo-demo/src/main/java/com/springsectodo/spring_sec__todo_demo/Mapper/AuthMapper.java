package com.springsectodo.spring_sec__todo_demo.Mapper;

import com.springsectodo.spring_sec__todo_demo.DTO.LoginRequestDTO;
import com.springsectodo.spring_sec__todo_demo.DTO.LoginResponseDTO;
import com.springsectodo.spring_sec__todo_demo.DTO.SignupRequestDTO;

public class AuthMapper {
    public static String toUsername(LoginRequestDTO dto ) {
        return dto.getUsername();

    }
    public static String toPassword(LoginRequestDTO dto){
        return dto.getPassword();
    }


    public static LoginResponseDTO toReponse(String token){
        return new LoginResponseDTO(token);
    }
}
