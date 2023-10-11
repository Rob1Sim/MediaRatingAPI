package com.rob1sim.mediarating.Services;

import com.rob1sim.mediarating.Entity.Role;
import com.rob1sim.mediarating.Entity.UserEntity;
import com.rob1sim.mediarating.Repositories.RoleRepository;
import com.rob1sim.mediarating.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetails implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    public UserEntity createUser(UserEntity userEntity, long roleId){
        //TODO : Lié l'entité au role
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getReferenceById(roleId));
        userEntity.setRoles(roles);
        return userRepository.save(userEntity);
    }
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findUserByEmailOrUsername(username, username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not exists by Username");
        }
        UserEntity userEntity = user.get() ;
        Set<GrantedAuthority> authorities = userEntity.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new User(username,userEntity.getPassword(),authorities);
    }
}

