package com.rob1sim.mediarating.Entity.DTO;

import com.rob1sim.mediarating.Entity.UserEntity;

import java.security.InvalidParameterException;

public record RegisterDTO(String username, String password, String email) {
    public UserEntity toUserEntity() {
        if (!isEmailValid(email)){
            throw new InvalidParameterException("The email is not valid");
        }
        return new UserEntity().username(username).password(password).email(email);
    }
    public boolean isEmailValid(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }

}
