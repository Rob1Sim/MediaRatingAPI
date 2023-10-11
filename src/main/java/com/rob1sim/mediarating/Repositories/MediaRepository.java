package com.rob1sim.mediarating.Repositories;

import com.rob1sim.mediarating.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media,Long> {
}
