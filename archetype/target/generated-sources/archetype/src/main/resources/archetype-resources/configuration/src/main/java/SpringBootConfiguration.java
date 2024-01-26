#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.${artifactId}.EnableWebSecurity;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "${package}.mappers",
        "${package}.logs",
        "${package}.services",
        "${package}.operations"

})

@EnableJpaRepositories(basePackages = {
        "${package}.repositories",

})

@EntityScan(basePackages = {
        "${package}.entities",

})
@EnableWebSecurity
public class SpringBootConfiguration {
}
