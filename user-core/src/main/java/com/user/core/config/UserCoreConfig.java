package com.user.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(value = {"com.user.core.domain"})
@Import({QuerydslConfig.class})
@EnableJpaRepositories(value = {"com.user.core.repository"})
@EnableJpaAuditing
public class UserCoreConfig {
}
