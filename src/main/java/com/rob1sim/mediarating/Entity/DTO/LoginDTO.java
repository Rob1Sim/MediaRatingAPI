package com.rob1sim.mediarating.Entity.DTO;

/**
 * Class de transfère elle ne contients que les informations nécéssaire à l'authentificaiton de l'utilisateur
 */
public class LoginDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
