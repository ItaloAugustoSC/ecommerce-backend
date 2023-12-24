package com.general.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/** JPA Repository configuration class. */
@Configuration
@EnableJpaRepositories(basePackages = "com.general.ecommerce.repository")
public class JpaRepositoryConfig {
}
