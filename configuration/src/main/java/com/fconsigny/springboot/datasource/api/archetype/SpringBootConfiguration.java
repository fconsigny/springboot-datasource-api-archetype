package com.fconsigny.springboot.datasource.api.archetype;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "com.fconsigny.springboot.datasource.api.archetype.mappers",
        "com.fconsigny.springboot.datasource.api.archetype.logs",
        "com.fconsigny.springboot.datasource.api.archetype.services",
        "com.fconsigny.springboot.datasource.api.archetype.operations"

})

@EnableJpaRepositories(basePackages = {
        "com.fconsigny.springboot.datasource.api.archetype.repositories",

})

@EntityScan(basePackages = {
        "com.fconsigny.springboot.datasource.api.archetype.entities",

})
@EnableWebSecurity
public class SpringBootConfiguration {
}
