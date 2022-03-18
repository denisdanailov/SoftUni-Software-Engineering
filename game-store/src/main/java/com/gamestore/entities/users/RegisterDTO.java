package com.gamestore.entities.users;

/*
 * Validate the data for registering a user.
 * @param commandParts all data read from console
 *
 * commandParts[0] is skipped because it contains the command name which is not needed the
 * in the user object
 * Email must be commandParts[1]
 * Password must be commandParts[2]
 * ConfirmPassword must be commandParts[3]
 * FullName must be commandParts[4]
 *
 * */

import com.gamestore.exceptions.ValidationException;

public class RegisterDTO {
        private String email;
        private String password;
        private String confirmPassword;
        private String fullName;

    public RegisterDTO(String commandParts[]) {
        this.email = commandParts[1];
        this.password = commandParts[2];
        this.confirmPassword = commandParts[3];
        this.fullName = commandParts[4];
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    private void validate() {
        if (!email.contains("@") || !email.contains(".")) {
            throw new ValidationException("Email must contain @ and .");
        }

//        TODO: Password validator

        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Password and confirm password must match!");
        }
    }



}
