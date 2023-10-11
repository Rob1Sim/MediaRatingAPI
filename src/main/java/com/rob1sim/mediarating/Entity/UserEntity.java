package com.rob1sim.mediarating.Entity;

import com.rob1sim.mediarating.Security.SecurityConfig;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany
    private Set<Media> mediaSet;
    @ManyToMany
    private Set<Role> roles;

    public UserEntity(){}
    public UserEntity username(String username){
        this.username = username;
        return this;
    }
    public UserEntity email(String email){
        this.email = email;
        return this;
    }
    public UserEntity password(String password){
        this.password = SecurityConfig.passwordEncoder().encode(password);
        return this;
    }
    public UserEntity mediaSet(Set<Media> mediaSet){
        this.mediaSet = mediaSet;
        return this;
    }
    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    protected void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public Set<Media> getMediaSet() {
        return mediaSet;
    }

    public void setMediaSet(Set<Media> mediaSet) {
        this.mediaSet = mediaSet;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
