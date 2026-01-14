package com.expensetracker.expensetrackerapi.user.UserDTO;

public class AuthResponseDTO {
    private String token;
    UserResponsDTO user;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    //getter and setter for user
    public UserResponsDTO getUser() {
        return this.user;
    }
    public void setUser(UserResponsDTO user) {
        this.user = user;
    }
}
