package com.rob1sim.mediarating.Repositories;

import com.rob1sim.mediarating.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findUserByEmailOrUsername(String username, String email);
}
