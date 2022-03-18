package com.gamestore.entities.users;

public class LoginDTO {
//    TODO: Validate Email
    private String email;
    private String password;

    public LoginDTO(String[] commandLineParts) {
        this.email = commandLineParts[1];
        this.password = commandLineParts[2];
    }
}
