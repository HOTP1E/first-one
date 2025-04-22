package ru.crew.management.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "ru.crew.management.repository")
@EnableTransactionManagement
@org.springframework.context.annotation.Configuration
public class Configuration {
}
