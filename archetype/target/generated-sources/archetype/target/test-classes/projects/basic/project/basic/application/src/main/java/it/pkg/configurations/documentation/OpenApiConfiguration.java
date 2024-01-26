package it.pkg.configurations.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Spring Boot Datasource Archetype", version = "1.0",
        description = " <h1> Greetings and User data handler </h1> " +
                "<p>Use this archetype to get boilerplate using <b>Spring Boot 3</b>, <b>Flyway data migration</b> and Basic <b>unit testing</b>.</p>" +
                "<p> Accessible resources are Greetings Hello, and User CRUD operations.</p>" +
                "<p> documentation can be found on <a href=\"https://github.com/fconsigny/springboot-datasource-api-archetype\">Github</a></p>" +
                "<p> Happy Coding! </p> ",
        contact = @Contact(name = "Francois CONSIGNY", email = "fconsigny@outlook.com")),
        security = {@SecurityRequirement(name = "x-api-key")}
)
@SecuritySchemes({
        @SecurityScheme(name = "x-api-key", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER, paramName = "x-api-key"),
})
public class OpenApiConfiguration {

    @Bean
    public OpenAPI springApiDocumentation() {
        return new OpenAPI()
                .components(new Components()

                        .addSecuritySchemes("x-api-key", new io.swagger.v3.oas.models.security.SecurityScheme()
                                .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.APIKEY)
                                .in(io.swagger.v3.oas.models.security.SecurityScheme.In.HEADER)
                                .name("x-api-key")))

                .externalDocs(new ExternalDocumentation()
                        .description("Github")
                        .url("https://github/fconsigny"));
    }

}
