package com.rob1sim.mediarating.Entity.DTO;

import com.rob1sim.mediarating.Entity.UserEntity;

public record RegisterDTO(String username, String password, String email) {
    public UserEntity toUserEntity() {
        return new UserEntity().username(username).password(password).email(email);
    }
}
