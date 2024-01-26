package it.pkg;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(SpringBootConfiguration.class)

public class ApplicationConfiguration {

}
