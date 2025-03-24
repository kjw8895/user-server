package com.user.api.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserApiMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiMasterApplication.class, args);
    }

}
