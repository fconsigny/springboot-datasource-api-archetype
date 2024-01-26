package it.pkg;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "it.pkg.mappers",
        "it.pkg.logs",
        "it.pkg.services",
        "it.pkg.operations"

})

@EnableJpaRepositories(basePackages = {
        "it.pkg.repositories",

})

@EntityScan(basePackages = {
        "it.pkg.entities",

})
@EnableWebSecurity
public class SpringBootConfiguration {
}
