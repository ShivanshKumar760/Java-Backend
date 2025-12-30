package com.blogjwt.Jwt_Blog.Mapper;

import com.blogjwt.Jwt_Blog.DTO.LoginRequestDTO;
import com.blogjwt.Jwt_Blog.DTO.LoginResponseDTO;

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
