package com.rob1sim.mediarating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.rob1sim.mediarating.Repositories")
public class MediaratingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaratingApplication.class, args);
	}

}
