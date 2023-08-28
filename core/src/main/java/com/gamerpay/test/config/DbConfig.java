package com.gamerpay.test.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.gamerpay.test.domain.model")
@EnableJpaRepositories("com.gamerpay.test.repository")
@EnableJpaAuditing
public class DbConfig {
}
